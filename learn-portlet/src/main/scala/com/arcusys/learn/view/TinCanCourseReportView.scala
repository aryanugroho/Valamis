package com.arcusys.learn.view

import javax.portlet._
import com.arcusys.learn.view.extensions._

class TinCanCourseReportView extends OAuthPortlet with BaseView {
  override def doView(request: RenderRequest, response: RenderResponse) {
    implicit val out = response.getWriter
    val contextPath = getContextPath(request)
    val data = Map(
      "contextPath" -> contextPath
    )
    sendTextFile("/templates/2.0/course_report_templates.html")
    sendMustacheFile(data, "course_report.html")
  }
}
