package com.smartpermission.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ArrayRes;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public abstract class AlertDialog {

    public interface Builder {
        AlertDialog create();

        @NonNull
        Context getContext();

        Builder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener);

        Builder setCancelable(boolean z);

        Builder setCursor(Cursor cursor, OnClickListener onClickListener, String str);

        Builder setCustomTitle(View view);

        Builder setIcon(@DrawableRes int i);

        Builder setIcon(Drawable drawable);

        Builder setIconAttribute(@AttrRes int i);

        Builder setItems(@ArrayRes int i, OnClickListener onClickListener);

        Builder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener);

        Builder setMessage(@StringRes int i);

        Builder setMessage(CharSequence charSequence);

        Builder setMultiChoiceItems(@ArrayRes int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener);

        Builder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener);

        Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener);

        Builder setNegativeButton(@StringRes int i, OnClickListener onClickListener);

        Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener);

        Builder setNeutralButton(@StringRes int i, OnClickListener onClickListener);

        Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener);

        Builder setOnCancelListener(OnCancelListener onCancelListener);

        Builder setOnDismissListener(OnDismissListener onDismissListener);

        Builder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener);

        Builder setOnKeyListener(OnKeyListener onKeyListener);

        Builder setPositiveButton(@StringRes int i, OnClickListener onClickListener);

        Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener);

        Builder setSingleChoiceItems(@ArrayRes int i, int i2, OnClickListener onClickListener);

        Builder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener);

        Builder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener);

        Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener);

        Builder setTitle(@StringRes int i);

        Builder setTitle(CharSequence charSequence);

        Builder setView(int i);

        Builder setView(View view);

        AlertDialog show();
    }

    private static class APi21Builder implements Builder {
        private android.app.AlertDialog.Builder builder;

        private APi21Builder(@NonNull Context context) {
            this(context, 0);
        }

        private APi21Builder(@NonNull Context context, @StyleRes int themeResId) {
            this.builder = new android.app.AlertDialog.Builder(context, themeResId);
        }

        @NonNull
        public Context getContext() {
            return this.builder.getContext();
        }

        public Builder setTitle(@StringRes int titleId) {
            this.builder.setTitle(titleId);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.builder.setTitle(title);
            return this;
        }

        public Builder setCustomTitle(View customTitleView) {
            this.builder.setCustomTitle(customTitleView);
            return this;
        }

        public Builder setMessage(@StringRes int messageId) {
            this.builder.setMessage(messageId);
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.builder.setMessage(message);
            return this;
        }

        public Builder setIcon(@DrawableRes int iconId) {
            this.builder.setIcon(iconId);
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.builder.setIcon(icon);
            return this;
        }

        public Builder setIconAttribute(@AttrRes int attrId) {
            this.builder.setIconAttribute(attrId);
            return this;
        }

        public Builder setPositiveButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setPositiveButton(textId, listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, OnClickListener listener) {
            this.builder.setPositiveButton(text, listener);
            return this;
        }

        public Builder setNegativeButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setNegativeButton(textId, listener);
            return this;
        }

        public Builder setNegativeButton(CharSequence text, OnClickListener listener) {
            this.builder.setNegativeButton(text, listener);
            return this;
        }

        public Builder setNeutralButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setNeutralButton(textId, listener);
            return this;
        }

        public Builder setNeutralButton(CharSequence text, OnClickListener listener) {
            this.builder.setNeutralButton(text, listener);
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.builder.setCancelable(cancelable);
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.builder.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            if (VERSION.SDK_INT >= 17) {
                this.builder.setOnDismissListener(onDismissListener);
            }
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.builder.setOnKeyListener(onKeyListener);
            return this;
        }

        public Builder setItems(@ArrayRes int itemsId, OnClickListener listener) {
            this.builder.setItems(itemsId, listener);
            return this;
        }

        public Builder setItems(CharSequence[] items, OnClickListener listener) {
            this.builder.setItems(items, listener);
            return this;
        }

        public Builder setAdapter(ListAdapter adapter, OnClickListener listener) {
            this.builder.setAdapter(adapter, listener);
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener listener, String labelColumn) {
            this.builder.setCursor(cursor, listener, labelColumn);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int itemsId, boolean[] checkedItems, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(itemsId, checkedItems, listener);
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(items, checkedItems, listener);
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, listener);
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int itemsId, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(itemsId, checkedItem, listener);
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, OnClickListener listener) {
            this.builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, listener);
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(items, checkedItem, listener);
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(adapter, checkedItem, listener);
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener listener) {
            this.builder.setOnItemSelectedListener(listener);
            return this;
        }

        public Builder setView(int layoutResId) {
            if (VERSION.SDK_INT >= 21) {
                this.builder.setView(layoutResId);
            }
            return this;
        }

        public Builder setView(View view) {
            this.builder.setView(view);
            return this;
        }

        public AlertDialog create() {
            return new Api21Dialog(this.builder.create());
        }

        public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }

    private static class Api20Builder implements Builder {
        private android.support.v7.app.AlertDialog.Builder builder;

        private Api20Builder(@NonNull Context context) {
            this(context, 0);
        }

        private Api20Builder(@NonNull Context context, @StyleRes int themeResId) {
            this.builder = new android.support.v7.app.AlertDialog.Builder(context, themeResId);
        }

        @NonNull
        public Context getContext() {
            return this.builder.getContext();
        }

        public Builder setTitle(@StringRes int titleId) {
            this.builder.setTitle(titleId);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.builder.setTitle(title);
            return this;
        }

        public Builder setCustomTitle(View customTitleView) {
            this.builder.setCustomTitle(customTitleView);
            return this;
        }

        public Builder setMessage(@StringRes int messageId) {
            this.builder.setMessage(messageId);
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.builder.setMessage(message);
            return this;
        }

        public Builder setIcon(@DrawableRes int iconId) {
            this.builder.setIcon(iconId);
            return this;
        }

        public Builder setIcon(Drawable icon) {
            this.builder.setIcon(icon);
            return this;
        }

        public Builder setIconAttribute(@AttrRes int attrId) {
            this.builder.setIconAttribute(attrId);
            return this;
        }

        public Builder setPositiveButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setPositiveButton(textId, listener);
            return this;
        }

        public Builder setPositiveButton(CharSequence text, OnClickListener listener) {
            this.builder.setPositiveButton(text, listener);
            return this;
        }

        public Builder setNegativeButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setNegativeButton(textId, listener);
            return this;
        }

        public Builder setNegativeButton(CharSequence text, OnClickListener listener) {
            this.builder.setNegativeButton(text, listener);
            return this;
        }

        public Builder setNeutralButton(@StringRes int textId, OnClickListener listener) {
            this.builder.setNeutralButton(textId, listener);
            return this;
        }

        public Builder setNeutralButton(CharSequence text, OnClickListener listener) {
            this.builder.setNeutralButton(text, listener);
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.builder.setCancelable(cancelable);
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.builder.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.builder.setOnDismissListener(onDismissListener);
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.builder.setOnKeyListener(onKeyListener);
            return this;
        }

        public Builder setItems(@ArrayRes int itemsId, OnClickListener listener) {
            this.builder.setItems(itemsId, listener);
            return this;
        }

        public Builder setItems(CharSequence[] items, OnClickListener listener) {
            this.builder.setItems(items, listener);
            return this;
        }

        public Builder setAdapter(ListAdapter adapter, OnClickListener listener) {
            this.builder.setAdapter(adapter, listener);
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener listener, String labelColumn) {
            this.builder.setCursor(cursor, listener, labelColumn);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int itemsId, boolean[] checkedItems, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(itemsId, checkedItems, listener);
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(items, checkedItems, listener);
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, OnMultiChoiceClickListener listener) {
            this.builder.setMultiChoiceItems(cursor, isCheckedColumn, labelColumn, listener);
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int itemsId, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(itemsId, checkedItem, listener);
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, OnClickListener listener) {
            this.builder.setSingleChoiceItems(cursor, checkedItem, labelColumn, listener);
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(items, checkedItem, listener);
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, OnClickListener listener) {
            this.builder.setSingleChoiceItems(adapter, checkedItem, listener);
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener listener) {
            this.builder.setOnItemSelectedListener(listener);
            return this;
        }

        public Builder setView(int layoutResId) {
            this.builder.setView(layoutResId);
            return this;
        }

        public Builder setView(View view) {
            this.builder.setView(view);
            return this;
        }

        public AlertDialog create() {
            return new Api20Dialog(this.builder.create());
        }

        public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }

    private static class Api20Dialog extends AlertDialog {
        private android.support.v7.app.AlertDialog alertDialog;

        private Api20Dialog(android.support.v7.app.AlertDialog alertDialog) {
            this.alertDialog = alertDialog;
        }

        public void show() {
            this.alertDialog.show();
        }

        public void dismiss() {
            if (this.alertDialog.isShowing()) {
                this.alertDialog.dismiss();
            }
        }

        public boolean isShowing() {
            return this.alertDialog.isShowing();
        }

        public void cancel() {
            if (this.alertDialog.isShowing()) {
                this.alertDialog.cancel();
            }
        }

        public Button getButton(int whichButton) {
            return this.alertDialog.getButton(whichButton);
        }

        @Nullable
        public ListView getListView() {
            return this.alertDialog.getListView();
        }

        @NonNull
        public Context getContext() {
            return this.alertDialog.getContext();
        }

        @Nullable
        public View getCurrentFocus() {
            return this.alertDialog.getCurrentFocus();
        }

        @NonNull
        public LayoutInflater getLayoutInflater() {
            return this.alertDialog.getLayoutInflater();
        }

        @Nullable
        public Activity getOwnerActivity() {
            return this.alertDialog.getOwnerActivity();
        }

        public int getVolumeControlStream() {
            return this.alertDialog.getVolumeControlStream();
        }

        @Nullable
        public Window getWindow() {
            return this.alertDialog.getWindow();
        }
    }

    private static class Api21Dialog extends AlertDialog {
        private android.app.AlertDialog alertDialogApp;

        private Api21Dialog(android.app.AlertDialog alertDialog) {
            this.alertDialogApp = alertDialog;
        }

        public void show() {
            this.alertDialogApp.show();
        }

        public void dismiss() {
            if (this.alertDialogApp.isShowing()) {
                this.alertDialogApp.dismiss();
            }
        }

        public boolean isShowing() {
            return this.alertDialogApp.isShowing();
        }

        public void cancel() {
            if (this.alertDialogApp.isShowing()) {
                this.alertDialogApp.cancel();
            }
        }

        public Button getButton(int whichButton) {
            return this.alertDialogApp.getButton(whichButton);
        }

        @Nullable
        public ListView getListView() {
            return this.alertDialogApp.getListView();
        }

        @NonNull
        public Context getContext() {
            return this.alertDialogApp.getContext();
        }

        @Nullable
        public View getCurrentFocus() {
            return this.alertDialogApp.getCurrentFocus();
        }

        @NonNull
        public LayoutInflater getLayoutInflater() {
            return this.alertDialogApp.getLayoutInflater();
        }

        @Nullable
        public Activity getOwnerActivity() {
            return this.alertDialogApp.getOwnerActivity();
        }

        public int getVolumeControlStream() {
            return this.alertDialogApp.getVolumeControlStream();
        }

        @Nullable
        public Window getWindow() {
            return this.alertDialogApp.getWindow();
        }
    }

    public abstract void cancel();

    public abstract void dismiss();

    public abstract Button getButton(int i);

    @NonNull
    public abstract Context getContext();

    @Nullable
    public abstract View getCurrentFocus();

    @NonNull
    public abstract LayoutInflater getLayoutInflater();

    @Nullable
    public abstract ListView getListView();

    @Nullable
    public abstract Activity getOwnerActivity();

    public abstract int getVolumeControlStream();

    @Nullable
    public abstract Window getWindow();

    public abstract boolean isShowing();

    public abstract void show();

    public static Builder newBuilder(Context context) {
        return VERSION.SDK_INT >= 21 ? new APi21Builder(context) : new Api20Builder(context);
    }

    public static Builder newBuilder(Context context, int themeResId) {
        return VERSION.SDK_INT >= 21 ? new APi21Builder(context, themeResId) : new Api20Builder(context, themeResId);
    }

    @Deprecated
    public static Builder build(Context context) {
        return newBuilder(context);
    }

    public static Builder build(Context context, int themeResId) {
        return newBuilder(context, themeResId);
    }
}
