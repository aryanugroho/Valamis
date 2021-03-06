package com.arcusys.learn.liferay.service

import java.net.URLEncoder
import javax.portlet.PortletURL
import javax.servlet.http.HttpServletResponse

import com.arcusys.learn.liferay.LiferayClasses._
import com.arcusys.learn.liferay.service.utils.PortletKeys
import com.arcusys.learn.liferay.services.AssetEntryLocalServiceHelper
import com.arcusys.valamis.certificate.model.Certificate

class OpenCertificateAction extends BaseOpenAction {
  override val portletId = PortletKeys.ValamisCertificate

  override def getById(id: Long): Option[LAssetEntry] =
    Option(
      AssetEntryLocalServiceHelper.getAssetEntry(classOf[Certificate].getName, id)
    )

  override def sendResponse(response: HttpServletResponse, portletURL: PortletURL, assetEntry: Option[LAssetEntry]) = {
    val hash = assetEntry.map(i => "/certificate/" + i.getClassPK).getOrElse("")
    response.sendRedirect(portletURL.toString + "&hash=" + URLEncoder.encode(hash, "UTF-8"))
  }
}
