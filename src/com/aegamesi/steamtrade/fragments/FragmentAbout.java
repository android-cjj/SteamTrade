package com.aegamesi.steamtrade.fragments;

import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aegamesi.steamtrade.R;

public class FragmentAbout extends FragmentBase {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		fragmentName = "FragmentAbout";
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_about, container, false);
		String version = "";
		try {
			version = activity().getPackageManager().getPackageInfo(activity().getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		TextView textAbout = (TextView) v.findViewById(R.id.ice_text_about);
		textAbout.setMovementMethod(LinkMovementMethod.getInstance());
		textAbout.setText(Html.fromHtml(getString(R.string.ice_about)));

		return v;
	}
}