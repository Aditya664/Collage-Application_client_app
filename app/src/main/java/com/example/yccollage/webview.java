package com.example.yccollage;

import android.graphics.Bitmap;

public interface webview {


    void onPageStarted(String url, Bitmap favicon);

    void onPageFinished(String url);

    void onPageError(int errorCode, String description, String failingUrl);

    void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent);

    void onExternalPageRequest(String url);


}
