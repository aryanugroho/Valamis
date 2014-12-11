package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the LFQuizAnswerScore service. Represents a row in the &quot;Learn_LFQuizAnswerScore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScore
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreImpl
 * @see com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl
 * @generated
 */
public interface LFQuizAnswerScoreModel extends BaseModel<LFQuizAnswerScore> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a l f quiz answer score model instance should use the {@link LFQuizAnswerScore} interface instead.
     */

    /**
     * Returns the primary key of this l f quiz answer score.
     *
     * @return the primary key of this l f quiz answer score
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this l f quiz answer score.
     *
     * @param primaryKey the primary key of this l f quiz answer score
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the answer ID of this l f quiz answer score.
     *
     * @return the answer ID of this l f quiz answer score
     */
    public long getAnswerId();

    /**
     * Sets the answer ID of this l f quiz answer score.
     *
     * @param answerId the answer ID of this l f quiz answer score
     */
    public void setAnswerId(long answerId);

    /**
     * Returns the score of this l f quiz answer score.
     *
     * @return the score of this l f quiz answer score
     */
    public Double getScore();

    /**
     * Sets the score of this l f quiz answer score.
     *
     * @param score the score of this l f quiz answer score
     */
    public void setScore(Double score);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(LFQuizAnswerScore lfQuizAnswerScore);

    @Override
    public int hashCode();

    @Override
    public CacheModel<LFQuizAnswerScore> toCacheModel();

    @Override
    public LFQuizAnswerScore toEscapedModel();

    @Override
    public LFQuizAnswerScore toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}