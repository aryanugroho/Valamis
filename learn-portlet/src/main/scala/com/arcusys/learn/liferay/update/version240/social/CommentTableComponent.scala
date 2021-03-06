package com.arcusys.learn.liferay.update.version240.social

import com.arcusys.valamis.core.DbNameUtils._
import com.arcusys.valamis.joda.JodaDateTimeMapper
import org.joda.time.DateTime

import scala.slick.driver.{JdbcDriver, JdbcProfile}

trait CommentTableComponent {
  protected val driver: JdbcProfile
  import driver.simple._

  type Comment = (Long, Long, String, Long, Option[Long], DateTime, Option[DateTime])
  class CommentTable(tag: Tag) extends Table[Comment](tag, tblName("COMMENT")) {
    implicit val jodaMapper = new JodaDateTimeMapper(driver.asInstanceOf[JdbcDriver]).typeMapper

    def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
    def companyId = column[Long]("COMPANY_ID")
    def userId = column[Long]("USER_ID")
    def content = column[String]("CONTENT")
    def activityId = column[Long]("ACTIVITY_ID")
    def creationDate = column[DateTime]("CREATION_DATE")
    def lastUpdateDate = column[Option[DateTime]]("LAST_UPDATE_DATE")

    def * = (companyId, userId, content, activityId, id.?, creationDate, lastUpdateDate)
  }

  val comments = TableQuery[CommentTable]
}
