package com.awais.gifloadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class LoadingDialog {
    private static Context context;
    private Dialog dialog;
    private int currentDrawable = -1;
    private String gifURL = "";

    private static LoadingDialog loadingDialog;

    public static LoadingDialog getInstance(Context ctx) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog();
        }
        context = ctx;
        return loadingDialog;
    }

    public void showDialog() {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_loading_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        ImageView gifImageView = dialog.findViewById(R.id.custom_loading_imageView);

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(gifImageView);
        if (getGifURL().equals("")) {
            if (getCurrentDrawable() == -1) {
                Glide.with(context).load(R.drawable.loading).into(imageViewTarget);
            } else {
                Glide.with(context).load(getCurrentDrawable()).into(imageViewTarget);
            }
        } else {
            Glide.with(context).load(getGifURL())
                    .placeholder(R.drawable.loading)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .crossFade(500)
                    .into(imageViewTarget);
        }
        dialog.show();
    }

    public void hideDialog() {
        dialog.dismiss();
    }

    public int getCurrentDrawable() {
        return currentDrawable;
    }

    public void setCurrentDrawable(int currentDrawable) {
        this.currentDrawable = currentDrawable;
    }

    public String getGifURL() {
        return gifURL;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }


}
