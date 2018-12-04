package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/**
 * A {@link BitmapTransformation} which rotates the bitmap.
 */
public class Rotate extends BitmapTransformation {
  private static final String ID = "com.bumptech.glide.load.resource.bitmap.Rotate";
  private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

  private final int degreesToRotate;

  /**
    * @param degreesToRotate number of degrees to rotate the image by. If zero the original image is
    *                        not modified.
   */
  public Rotate(int degreesToRotate) {
    this.degreesToRotate = degreesToRotate;
  }

  @Override
  protected Bitmap transform(
      @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
    return TransformationUtils.rotateImage(toTransform, degreesToRotate);
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Rotate;
  }

  @Override
  public int hashCode() {
    return ID.hashCode();
  }

  @Override
  public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    messageDigest.update(ID_BYTES);
  }
}
