package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTCClntApiStorageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStorageLocalService
 * @generated
 */
public class LFTCClntApiStorageLocalServiceWrapper
    implements LFTCClntApiStorageLocalService,
        ServiceWrapper<LFTCClntApiStorageLocalService> {
    private LFTCClntApiStorageLocalService _lftcClntApiStorageLocalService;

    public LFTCClntApiStorageLocalServiceWrapper(
        LFTCClntApiStorageLocalService lftcClntApiStorageLocalService) {
        _lftcClntApiStorageLocalService = lftcClntApiStorageLocalService;
    }

    /**
    * Adds the l f t c clnt api storage to the database. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage addLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.addLFTCClntApiStorage(lftcClntApiStorage);
    }

    /**
    * Creates a new l f t c clnt api storage with the primary key. Does not add the l f t c clnt api storage to the database.
    *
    * @param id the primary key for the new l f t c clnt api storage
    * @return the new l f t c clnt api storage
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage createLFTCClntApiStorage(
        long id) {
        return _lftcClntApiStorageLocalService.createLFTCClntApiStorage(id);
    }

    /**
    * Deletes the l f t c clnt api storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage that was removed
    * @throws PortalException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage deleteLFTCClntApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.deleteLFTCClntApiStorage(id);
    }

    /**
    * Deletes the l f t c clnt api storage from the database. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage deleteLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.deleteLFTCClntApiStorage(lftcClntApiStorage);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lftcClntApiStorageLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchLFTCClntApiStorage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.fetchLFTCClntApiStorage(id);
    }

    /**
    * Returns the l f t c clnt api storage with the primary key.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage
    * @throws PortalException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage getLFTCClntApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.getLFTCClntApiStorage(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f t c clnt api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f t c clnt api storages
    * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
    * @return the range of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> getLFTCClntApiStorages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.getLFTCClntApiStorages(start, end);
    }

    /**
    * Returns the number of l f t c clnt api storages.
    *
    * @return the number of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTCClntApiStoragesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.getLFTCClntApiStoragesCount();
    }

    /**
    * Updates the l f t c clnt api storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage updateLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.updateLFTCClntApiStorage(lftcClntApiStorage);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lftcClntApiStorageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lftcClntApiStorageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lftcClntApiStorageLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.findByToken(token);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lftcClntApiStorageLocalService.findByCode(code);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTCClntApiStorageLocalService getWrappedLFTCClntApiStorageLocalService() {
        return _lftcClntApiStorageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTCClntApiStorageLocalService(
        LFTCClntApiStorageLocalService lftcClntApiStorageLocalService) {
        _lftcClntApiStorageLocalService = lftcClntApiStorageLocalService;
    }

    @Override
    public LFTCClntApiStorageLocalService getWrappedService() {
        return _lftcClntApiStorageLocalService;
    }

    @Override
    public void setWrappedService(
        LFTCClntApiStorageLocalService lftcClntApiStorageLocalService) {
        _lftcClntApiStorageLocalService = lftcClntApiStorageLocalService;
    }
}
