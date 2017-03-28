/**
 * Checking SDK Configuration 
 * 
 * @author DroidOXY
 */

package com.droidoxy.easymoneyrewards;

import net.adxmi.android.os.OffersManager;
import net.adxmi.android.os.PointsManager;
import net.adxmi.android.video.VideoAdManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class CheckSdkConfig {
	
	/**
	 *  Checking  OfferWall advertisement configuration
	 */
	static void checkOfferConfig(Context context) {
		StringBuilder sb = new StringBuilder();

		// Checking OfferWall advertisement configuration (If you don't use <Acquire earning points order list through receiver>,
		// then use this method to check advertisement configuration)
		boolean isCorrect = OffersManager.getInstance(context).checkOffersAdConfig();

		addTextToSb(
				sb,
				isCorrect ? "OfferWall Advertisement Configuration Result: Normal"
						: "OfferWall Advertisement Configuration Result: Abnormal, please check the Log for abnormal details, Log label:YoumiSdk");
		addTextToSb(sb, "If enable server call-back:%b", OffersManager.isUsingServerCallBack());
		addTextToSb(sb, "If enable earning currency points notification bar hint:%b",
				PointsManager.isEnableEarnPointsNotification());
		addTextToSb(sb, "If enable earning currency points Toast hint:%b",
				PointsManager.isEnableEarnPointsToastTips());
		new AlertDialog.Builder(context).setTitle("Check result").setMessage(sb.toString())
				.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).create().show();
	}
	
	/**
	 * Checking  Video advertisement configuration
	 */
	static void checkVideoConfig(Context context) {
		StringBuilder sb = new StringBuilder();

		boolean isCorrect = VideoAdManager.getInstance(context).checkVideoAdConfig();
		addTextToSb(sb, isCorrect ? "Video Advertisement Configuration Result: Normal" 
				: "Video Advertisement Configuration Result: Abnormal, please check the Log for abnormal details, Log label:YoumiSdk");
		addTextToSb(sb, "If enable server call-back:%b", VideoAdManager.isUsingServerCallBack());
		addTextToSb(sb, "If enable jump to webview page when click a close btn:%b", VideoAdManager.isEnableCloseBtnToDetail());
		addTextToSb(sb, "If enable earning video currency points Toast hint:%b", VideoAdManager.isEnableRewardsToastTips());
		new  AlertDialog.Builder(context).setTitle("Check result").setMessage(sb.toString())
				.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).create().show();
	}
	private static void addTextToSb(StringBuilder sb, String format, Object... args) {
		sb.append(String.format(format, args));
		sb.append(System.getProperty("line.separator"));
	}
}
