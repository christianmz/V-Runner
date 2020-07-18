package com.meazza.v_runner.di

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.meazza.v_runner.R
import com.meazza.v_runner.common.Constants
import com.meazza.v_runner.common.Constants.NOTIFICATION_CHANNEL_ID
import com.meazza.v_runner.ui.HostActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped


@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {

    @ServiceScoped
    @Provides
    fun providesFusedLocationProviderClient(@ApplicationContext context: Context) =
        FusedLocationProviderClient(context)

    @ServiceScoped
    @Provides
    fun providesHostActivityPendingIntent(@ApplicationContext context: Context): PendingIntent {
        return PendingIntent.getActivity(
            context,
            0,
            Intent(context, HostActivity::class.java).also {
                it.action = Constants.ACTION_SHOW_TRACKING_FRAGMENT
            },
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    @ServiceScoped
    @Provides
    fun providesBaseNotificationBuilder(
        @ApplicationContext context: Context, pendingIntent: PendingIntent
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_run)
            .setContentTitle(context.getString(R.string.app_name))
            .setContentText("00:00:00")
            .setContentIntent(pendingIntent)
    }
}