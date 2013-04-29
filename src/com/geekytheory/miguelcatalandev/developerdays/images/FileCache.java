package com.geekytheory.miguelcatalandev.developerdays.images;

import java.io.File;
import android.content.Context;
import android.os.Environment;

public class FileCache {

	private File cacheDir;

	public FileCache(Context context) {
		// Find the dir to save cached images
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			cacheDir = new File(
					(Environment.getExternalStorageDirectory().toString())
							+ "/Android/data/com.geekytheory.miguelcatalandev.developerdays/Cache/Images/");
		else
			cacheDir = context.getCacheDir();
		if (!cacheDir.exists())
			cacheDir.mkdirs();
	}

	public File getFile(String url) {
		// I identify images by hashcode. Not a perfect solution.
		String filename = String.valueOf(url.hashCode());
		File f = new File(cacheDir, filename);
		return f;

	}

	public void clear() {
		File[] files = cacheDir.listFiles();
		for (File f : files)
			f.delete();
	}

}