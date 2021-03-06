function showStudent(id){
    this.model=new GradebookStudentModel({id:id});
    var view = new StudentView({
        model: this.model,
        language: language
    });
    myLayout.modals.show(new StudentViewModal({view: view}));
}

GradebookDetailedStudentHeaderView = Backbone.View.extend({
    events: {
        "click .student-click": "showStudent"
    },

    initialize: function (options) {
        this.options = options;
        if (this.model.get('avatarUrl') == "")
            this.model.set('avatarUrl', 'http://placehold.it/48x48');
        var templateRow = Mustache.to_html(jQueryValamis("#detailedTableStudentHeaderTemplate").html(),
            _.extend(this.model.toJSON(), language, permissionActionsGradebook));


        this.$el = jQueryValamis(templateRow);
        //this.$('.detailed-row-header').attr("onclick","showStudent("+this.model.get('id')+");");
    },

    render: function () {
        return this.$el;
    },

    // Student view  modal
    showStudent: function () {
        var view = new StudentView({
            model: this.model,
            language: this.options.language
        });
        view.on('refreshTotalGrade',this.options.parent.reloadGradeList,this.options.parent);
        myLayout.modals.show(new StudentViewModal({view: view}));
    }
});

GradebookDetailedPackageHeaderView = Backbone.View.extend({
    events: {
    },

    initialize: function (options) {
        this.options = options;
    },


    render: function () {
        var templateRow = Mustache.to_html(jQueryValamis("#detailedTablePackageHeaderTemplate").html(), _.extend(this.model, language, permissionActionsGradebook));
        this.$el = jQueryValamis(templateRow);
        //jQueryValamis('#packageNames').append(this.$el);
        return this.$el;
    }
});

GradebookDetailedListView = Backbone.View.extend({
    events: {
        //"click .sortable":"sortStudents"
        "click .student-click": "showStudent"
    },

    initialize: function (options) {
        this.options = options;
        this.sortableAscOrder = [];

        var template = Mustache.to_html(jQueryValamis("#detailedTableTemplate").html(), _.extend(this.options.language, permissionActionsGradebook));

        this.$el.html(template);

        this.packages = new Object();

        this.paginator = new ValamisPaginator({el: jQueryValamis('#gradebookPaginator'), model: this.model.get('paginatorModel'), language: this.options.language});


    },

    render: function () {
        this.paginator.render();
        var paginatorTotalElements = this.paginator.model.get('totalElements');

        if(paginatorTotalElements > this.paginator.model.get('itemsOnPage'))
            jQueryValamis('#gradebookPaginator').show();
        else
            jQueryValamis('#gradebookPaginator').hide();
        return this.$el;
    },


    reloadGradeList: function () {
        this.model.loadList({}, {
            success: jQueryValamis.proxy(function (res) {
                //this.model = new GradebookModel(res);
                this.collection = new GradebookStudentCollection(res.records);
                this.addStudentsFromCollection();
                this.paginator.updateItems(res.total);
            }, this),
            error: function (err, res) {
                // do something in case of an error
                toastr.error(language['loadFailed']);
            }
        });
    },

    addStudent: function (student) {

        var header = new GradebookDetailedStudentHeaderView({
            model: student,
            language: this.options.language,
            parent: this
        });


        jQueryValamis('#studentGrid').append(header.render());

        this.rowGrades = jQueryValamis('<tr class="package-row" >');
        var packageGrades = student.get('packageGrades');
        packageGrades.forEach(this.addGrade, this);
        this.$('#detailedGradeGrid').append(this.rowGrades);
//        jQueryValamis('#gradeGrid').append(this.$el);
    },

    addGrade: function(grade){
        if (!this.packages[grade.id]) {
            this.packages[grade.id] = new GradebookDetailedPackageHeaderView({
                model: grade,
                language: this.options.language
            });
            var renderedView = this.packages[grade.id].render();
            this.$('#packageNames').append(renderedView);
        }


        var templateCell = Mustache.to_html(jQueryValamis("#detailedTableCellTemplate").html(), _.extend(grade, language, permissionActionsGradebook));
        this.rowGrades.append(templateCell);

    },

    addStudentsFromCollection: function () {

//        var template = Mustache.to_html(jQueryValamis("#detailedTableTemplate").html(), this.options.language);
//
//        this.$el.html(template);
        this.$('#studentGrid').empty();
        this.$('#packageNames').empty();
        this.$('#detailedGradeGrid').empty();
        this.packages=new Object();


        this.collection.each(this.addStudent, this);

        var maxHeight=Math.max(this.$('table#GradeDetailedTableFixed thead tr').height(),this.$('table#GradeDetailedTable thead tr').height());
        this.$('table#GradeDetailedTable thead tr').height(maxHeight);
        this.$('table#GradeDetailedTableFixed thead tr').height(maxHeight);

        for(var i=0;i<this.$('table#GradeDetailedTableFixed tbody tr').length;i++) {
            var maxHeight=Math.max(this.$('table#GradeDetailedTableFixed tbody tr:eq('+i+')').height(),this.$('table#GradeDetailedTable tbody tr:eq('+i+')').height());
            this.$('table#GradeDetailedTable tbody tr:eq('+i+')').height(maxHeight);
            this.$('table#GradeDetailedTableFixed tbody tr:eq('+i+')').height(maxHeight);
        }

        this.$('.scrollBody').width(this.$('#detailedTableWrapper').width() - this.$('#tdHeader').width());

    }
});
