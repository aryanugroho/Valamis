package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException;
import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f activity data map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMapPersistence
 * @see LFActivityDataMapUtil
 * @generated
 */
public class LFActivityDataMapPersistenceImpl extends BasePersistenceImpl<LFActivityDataMap>
    implements LFActivityDataMapPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityDataMapUtil} to access the l f activity data map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityDataMapImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED,
            LFActivityDataMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED,
            LFActivityDataMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID =
        new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED,
            LFActivityDataMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndActivityID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID =
        new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED,
            LFActivityDataMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndActivityID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityDataMapModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityDataMapModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDACTIVITYID = new FinderPath(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndActivityID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_NULL =
        "lfActivityDataMap.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_2 =
        "lfActivityDataMap.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_NULL_2 =
        "lfActivityDataMap.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_1 =
        "lfActivityDataMap.activityID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_NULL =
        "lfActivityDataMap.activityID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_2 =
        "lfActivityDataMap.activityID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_NULL_2 =
        "lfActivityDataMap.activityID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3 =
        "(lfActivityDataMap.activityID IS NULL OR lfActivityDataMap.activityID = '')";
    private static final String _SQL_SELECT_LFACTIVITYDATAMAP = "SELECT lfActivityDataMap FROM LFActivityDataMap lfActivityDataMap";
    private static final String _SQL_SELECT_LFACTIVITYDATAMAP_WHERE = "SELECT lfActivityDataMap FROM LFActivityDataMap lfActivityDataMap WHERE ";
    private static final String _SQL_COUNT_LFACTIVITYDATAMAP = "SELECT COUNT(lfActivityDataMap) FROM LFActivityDataMap lfActivityDataMap";
    private static final String _SQL_COUNT_LFACTIVITYDATAMAP_WHERE = "SELECT COUNT(lfActivityDataMap) FROM LFActivityDataMap lfActivityDataMap WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivityDataMap.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivityDataMap exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivityDataMap exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityDataMapPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFActivityDataMap _nullLFActivityDataMap = new LFActivityDataMapImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivityDataMap> toCacheModel() {
                return _nullLFActivityDataMapCacheModel;
            }
        };

    private static CacheModel<LFActivityDataMap> _nullLFActivityDataMapCacheModel =
        new CacheModel<LFActivityDataMap>() {
            @Override
            public LFActivityDataMap toEntityModel() {
                return _nullLFActivityDataMap;
            }
        };

    public LFActivityDataMapPersistenceImpl() {
        setModelClass(LFActivityDataMap.class);
    }

    /**
     * Returns all the l f activity data maps where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the matching l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findByPackageIDAndActivityID(
        Integer packageID, String activityID) throws SystemException {
        return findByPackageIDAndActivityID(packageID, activityID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity data maps
     * @param end the upper bound of the range of l f activity data maps (not inclusive)
     * @return the range of matching l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findByPackageIDAndActivityID(
        Integer packageID, String activityID, int start, int end)
        throws SystemException {
        return findByPackageIDAndActivityID(packageID, activityID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f activity data maps
     * @param end the upper bound of the range of l f activity data maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findByPackageIDAndActivityID(
        Integer packageID, String activityID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID;
            finderArgs = new Object[] { packageID, activityID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID;
            finderArgs = new Object[] {
                    packageID, activityID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivityDataMap> list = (List<LFActivityDataMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivityDataMap lfActivityDataMap : list) {
                if (!Validator.equals(packageID,
                            lfActivityDataMap.getPackageID()) ||
                        !Validator.equals(activityID,
                            lfActivityDataMap.getActivityID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFACTIVITYDATAMAP_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFActivityDataMapModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
                }

                if (!pagination) {
                    list = (List<LFActivityDataMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityDataMap>(list);
                } else {
                    list = (List<LFActivityDataMap>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity data map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a matching l f activity data map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap findByPackageIDAndActivityID_First(
        Integer packageID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityDataMapException, SystemException {
        LFActivityDataMap lfActivityDataMap = fetchByPackageIDAndActivityID_First(packageID,
                activityID, orderByComparator);

        if (lfActivityDataMap != null) {
            return lfActivityDataMap;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityDataMapException(msg.toString());
    }

    /**
     * Returns the first l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap fetchByPackageIDAndActivityID_First(
        Integer packageID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivityDataMap> list = findByPackageIDAndActivityID(packageID,
                activityID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity data map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a matching l f activity data map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap findByPackageIDAndActivityID_Last(
        Integer packageID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityDataMapException, SystemException {
        LFActivityDataMap lfActivityDataMap = fetchByPackageIDAndActivityID_Last(packageID,
                activityID, orderByComparator);

        if (lfActivityDataMap != null) {
            return lfActivityDataMap;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityDataMapException(msg.toString());
    }

    /**
     * Returns the last l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap fetchByPackageIDAndActivityID_Last(
        Integer packageID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageIDAndActivityID(packageID, activityID);

        if (count == 0) {
            return null;
        }

        List<LFActivityDataMap> list = findByPackageIDAndActivityID(packageID,
                activityID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activity data maps before and after the current l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
     *
     * @param id the primary key of the current l f activity data map
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity data map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap[] findByPackageIDAndActivityID_PrevAndNext(
        long id, Integer packageID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityDataMapException, SystemException {
        LFActivityDataMap lfActivityDataMap = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFActivityDataMap[] array = new LFActivityDataMapImpl[3];

            array[0] = getByPackageIDAndActivityID_PrevAndNext(session,
                    lfActivityDataMap, packageID, activityID,
                    orderByComparator, true);

            array[1] = lfActivityDataMap;

            array[2] = getByPackageIDAndActivityID_PrevAndNext(session,
                    lfActivityDataMap, packageID, activityID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivityDataMap getByPackageIDAndActivityID_PrevAndNext(
        Session session, LFActivityDataMap lfActivityDataMap,
        Integer packageID, String activityID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITYDATAMAP_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_2);
        }

        boolean bindActivityID = false;

        if (activityID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_1);
        } else if (activityID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
        } else {
            bindActivityID = true;

            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LFActivityDataMapModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (bindActivityID) {
            if (activityID != null) {
                qPos.add(activityID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivityDataMap);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivityDataMap> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activity data maps where packageID = &#63; and activityID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageIDAndActivityID(Integer packageID,
        String activityID) throws SystemException {
        for (LFActivityDataMap lfActivityDataMap : findByPackageIDAndActivityID(
                packageID, activityID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfActivityDataMap);
        }
    }

    /**
     * Returns the number of l f activity data maps where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the number of matching l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageIDAndActivityID(Integer packageID,
        String activityID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEIDANDACTIVITYID;

        Object[] finderArgs = new Object[] { packageID, activityID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITYDATAMAP_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_PACKAGEID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDACTIVITYID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f activity data map in the entity cache if it is enabled.
     *
     * @param lfActivityDataMap the l f activity data map
     */
    @Override
    public void cacheResult(LFActivityDataMap lfActivityDataMap) {
        EntityCacheUtil.putResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapImpl.class, lfActivityDataMap.getPrimaryKey(),
            lfActivityDataMap);

        lfActivityDataMap.resetOriginalValues();
    }

    /**
     * Caches the l f activity data maps in the entity cache if it is enabled.
     *
     * @param lfActivityDataMaps the l f activity data maps
     */
    @Override
    public void cacheResult(List<LFActivityDataMap> lfActivityDataMaps) {
        for (LFActivityDataMap lfActivityDataMap : lfActivityDataMaps) {
            if (EntityCacheUtil.getResult(
                        LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityDataMapImpl.class,
                        lfActivityDataMap.getPrimaryKey()) == null) {
                cacheResult(lfActivityDataMap);
            } else {
                lfActivityDataMap.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activity data maps.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityDataMapImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityDataMapImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity data map.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivityDataMap lfActivityDataMap) {
        EntityCacheUtil.removeResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapImpl.class, lfActivityDataMap.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFActivityDataMap> lfActivityDataMaps) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivityDataMap lfActivityDataMap : lfActivityDataMaps) {
            EntityCacheUtil.removeResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityDataMapImpl.class, lfActivityDataMap.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f activity data map with the primary key. Does not add the l f activity data map to the database.
     *
     * @param id the primary key for the new l f activity data map
     * @return the new l f activity data map
     */
    @Override
    public LFActivityDataMap create(long id) {
        LFActivityDataMap lfActivityDataMap = new LFActivityDataMapImpl();

        lfActivityDataMap.setNew(true);
        lfActivityDataMap.setPrimaryKey(id);

        return lfActivityDataMap;
    }

    /**
     * Removes the l f activity data map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f activity data map
     * @return the l f activity data map that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap remove(long id)
        throws NoSuchLFActivityDataMapException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f activity data map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity data map
     * @return the l f activity data map that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap remove(Serializable primaryKey)
        throws NoSuchLFActivityDataMapException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivityDataMap lfActivityDataMap = (LFActivityDataMap) session.get(LFActivityDataMapImpl.class,
                    primaryKey);

            if (lfActivityDataMap == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityDataMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivityDataMap);
        } catch (NoSuchLFActivityDataMapException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivityDataMap removeImpl(LFActivityDataMap lfActivityDataMap)
        throws SystemException {
        lfActivityDataMap = toUnwrappedModel(lfActivityDataMap);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfActivityDataMap)) {
                lfActivityDataMap = (LFActivityDataMap) session.get(LFActivityDataMapImpl.class,
                        lfActivityDataMap.getPrimaryKeyObj());
            }

            if (lfActivityDataMap != null) {
                session.delete(lfActivityDataMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfActivityDataMap != null) {
            clearCache(lfActivityDataMap);
        }

        return lfActivityDataMap;
    }

    @Override
    public LFActivityDataMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap)
        throws SystemException {
        lfActivityDataMap = toUnwrappedModel(lfActivityDataMap);

        boolean isNew = lfActivityDataMap.isNew();

        LFActivityDataMapModelImpl lfActivityDataMapModelImpl = (LFActivityDataMapModelImpl) lfActivityDataMap;

        Session session = null;

        try {
            session = openSession();

            if (lfActivityDataMap.isNew()) {
                session.save(lfActivityDataMap);

                lfActivityDataMap.setNew(false);
            } else {
                session.merge(lfActivityDataMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityDataMapModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfActivityDataMapModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityDataMapModelImpl.getOriginalPackageID(),
                        lfActivityDataMapModelImpl.getOriginalActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID,
                    args);

                args = new Object[] {
                        lfActivityDataMapModelImpl.getPackageID(),
                        lfActivityDataMapModelImpl.getActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDACTIVITYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityDataMapImpl.class, lfActivityDataMap.getPrimaryKey(),
            lfActivityDataMap);

        return lfActivityDataMap;
    }

    protected LFActivityDataMap toUnwrappedModel(
        LFActivityDataMap lfActivityDataMap) {
        if (lfActivityDataMap instanceof LFActivityDataMapImpl) {
            return lfActivityDataMap;
        }

        LFActivityDataMapImpl lfActivityDataMapImpl = new LFActivityDataMapImpl();

        lfActivityDataMapImpl.setNew(lfActivityDataMap.isNew());
        lfActivityDataMapImpl.setPrimaryKey(lfActivityDataMap.getPrimaryKey());

        lfActivityDataMapImpl.setId(lfActivityDataMap.getId());
        lfActivityDataMapImpl.setPackageID(lfActivityDataMap.getPackageID());
        lfActivityDataMapImpl.setActivityID(lfActivityDataMap.getActivityID());
        lfActivityDataMapImpl.setTargetId(lfActivityDataMap.getTargetId());
        lfActivityDataMapImpl.setReadSharedData(lfActivityDataMap.isReadSharedData());
        lfActivityDataMapImpl.setWriteSharedData(lfActivityDataMap.isWriteSharedData());

        return lfActivityDataMapImpl;
    }

    /**
     * Returns the l f activity data map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity data map
     * @return the l f activity data map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFActivityDataMapException, SystemException {
        LFActivityDataMap lfActivityDataMap = fetchByPrimaryKey(primaryKey);

        if (lfActivityDataMap == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFActivityDataMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfActivityDataMap;
    }

    /**
     * Returns the l f activity data map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException} if it could not be found.
     *
     * @param id the primary key of the l f activity data map
     * @return the l f activity data map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap findByPrimaryKey(long id)
        throws NoSuchLFActivityDataMapException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f activity data map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity data map
     * @return the l f activity data map, or <code>null</code> if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFActivityDataMap lfActivityDataMap = (LFActivityDataMap) EntityCacheUtil.getResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityDataMapImpl.class, primaryKey);

        if (lfActivityDataMap == _nullLFActivityDataMap) {
            return null;
        }

        if (lfActivityDataMap == null) {
            Session session = null;

            try {
                session = openSession();

                lfActivityDataMap = (LFActivityDataMap) session.get(LFActivityDataMapImpl.class,
                        primaryKey);

                if (lfActivityDataMap != null) {
                    cacheResult(lfActivityDataMap);
                } else {
                    EntityCacheUtil.putResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityDataMapImpl.class, primaryKey,
                        _nullLFActivityDataMap);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFActivityDataMapModelImpl.ENTITY_CACHE_ENABLED,
                    LFActivityDataMapImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfActivityDataMap;
    }

    /**
     * Returns the l f activity data map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f activity data map
     * @return the l f activity data map, or <code>null</code> if a l f activity data map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivityDataMap fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f activity data maps.
     *
     * @return the l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activity data maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activity data maps
     * @param end the upper bound of the range of l f activity data maps (not inclusive)
     * @return the range of l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activity data maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activity data maps
     * @param end the upper bound of the range of l f activity data maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivityDataMap> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFActivityDataMap> list = (List<LFActivityDataMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITYDATAMAP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITYDATAMAP;

                if (pagination) {
                    sql = sql.concat(LFActivityDataMapModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFActivityDataMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivityDataMap>(list);
                } else {
                    list = (List<LFActivityDataMap>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f activity data maps from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFActivityDataMap lfActivityDataMap : findAll()) {
            remove(lfActivityDataMap);
        }
    }

    /**
     * Returns the number of l f activity data maps.
     *
     * @return the number of l f activity data maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITYDATAMAP);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the l f activity data map persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivityDataMap")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivityDataMap>> listenersList = new ArrayList<ModelListener<LFActivityDataMap>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivityDataMap>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityDataMapImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
