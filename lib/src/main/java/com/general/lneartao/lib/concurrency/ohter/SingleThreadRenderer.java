package com.general.lneartao.lib.concurrency.ohter;

import java.util.ArrayList;
import java.util.List;

/**
 * 串行地渲染页面元素
 * 不要这么做
 *
 * @author lneartao
 * @date 2018/4/30.
 */
public abstract class SingleThreadRenderer {

    void renderPage(CharSequence charSequence) {
        renderText(charSequence);
        List<ImageData> imageData = new ArrayList<>();
        for (ImageInfo imageInfo : scanForImageInfo(charSequence)) {
            imageData.add(imageInfo.downloadImage());
        }
        for (ImageData imageData1 : imageData) {
            renderImage(imageData1);
        }
    }

    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    abstract void renderText(CharSequence s);

    abstract List<ImageInfo> scanForImageInfo(CharSequence s);

    abstract void renderImage(ImageData i);
}
