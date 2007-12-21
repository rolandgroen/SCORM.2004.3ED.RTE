package org.sakaiproject.scorm.ui;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.file.File;
import org.sakaiproject.scorm.model.api.SessionBean;
import org.sakaiproject.scorm.navigation.INavigable;
import org.sakaiproject.scorm.service.api.ScormResourceService;

public abstract class ResourceNavigator implements INavigable, Serializable {

	private static Log log = LogFactory.getLog(ResourceNavigator.class);
	
	protected abstract ScormResourceService resourceService();
	
	public void displayResource(final SessionBean sessionBean, Object target) {
		if (null == target)
			return;
		
		if (sessionBean.isEnded()) {		
			((AjaxRequestTarget)target).appendJavascript("window.location.href='" + sessionBean.getCompletionUrl() + "';");
		}
		
		String url = resourceService().getUrl(sessionBean);
		
		// Don't bother to display anything if a null url is returned. 
		if (null == url)
			return;
		
		if (log.isInfoEnabled())
			log.info("Going to " + url);
			
		((AjaxRequestTarget)target).appendJavascript("parent.scormContent.location.href='" + url + "'");
	}

	private byte[] streamBytes(InputStream inputStream) {
		int len = 0;
		byte[] buf = new byte[1024];
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		
		try {
			while ((len = inputStream.read(buf)) > 0) {
				byteOut.write(buf,0,len);
			}
			
			inputStream.close();
		} catch (IOException ioe) {
			log.error("Caught an io exception trying to write file into byte array!", ioe);
		}
		
		return byteOut.toByteArray();
	}
	
	
	private byte[] getFileAsBytes(File file) {
		int len = 0;
		byte[] buf = new byte[1024];
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		
		try {
			FileInputStream fileIn = new FileInputStream(file);
			while ((len = fileIn.read(buf)) > 0) {
				byteOut.write(buf,0,len);
			}
			
			fileIn.close();
		} catch (IOException ioe) {
			log.error("Caught an io exception trying to write file into byte array!", ioe);
		}
		
		return byteOut.toByteArray();
	}

}