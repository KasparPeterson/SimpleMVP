<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.kasparpeterson.example.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="This is a sample flow for this MVP usage.\nPlease enter your first name and last name in the fields below." />

    <EditText
        android:id="@+id/first_name_edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/activity_vertical_margin"
        android:hint="First name" />

    <EditText
        android:id="@+id/last_name_edit_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Last name" />

    <View
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <Button
        android:id="@+id/continue_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Continue" />

</LinearLayout>
