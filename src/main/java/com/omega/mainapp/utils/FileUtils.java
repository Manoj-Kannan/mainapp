package com.omega.mainapp.utils;

import org.apache.commons.io.FilenameUtils;

public class FileUtils {
    public static String normalizePath(String path) {
        return FilenameUtils.normalize(path);
    }
}
