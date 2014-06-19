package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;
import com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the LFPackageGradeStorage service. Represents a row in the &quot;Learn_LFPackageGradeStorage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LFPackageGradeStorageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageGradeStorageImpl
 * @see com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage
 * @generated
 */
public abstract class LFPackageGradeStorageBaseImpl
    extends LFPackageGradeStorageModelImpl implements LFPackageGradeStorage {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a l f package grade storage model instance should use the {@link LFPackageGradeStorage} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageGradeStorageLocalServiceUtil.addLFPackageGradeStorage(this);
        } else {
            LFPackageGradeStorageLocalServiceUtil.updateLFPackageGradeStorage(this);
        }
    }
}