package com.gemavi.backend.util;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("loader")
public class LoaderSettings {

	private File initFile;

	public File getInitFile() {
		return initFile;
	}

	public void setInitFile(File initFile) {
		this.initFile = initFile;
	}

}
