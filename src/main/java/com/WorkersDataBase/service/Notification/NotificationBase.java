package com.WorkersDataBase.service.Notification;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public abstract class NotificationBase {
    public final int notificationTimeDuration = 5000;
    public final NotificationVariant successTheme = NotificationVariant.LUMO_SUCCESS;
    public final NotificationVariant errorTheme = NotificationVariant.LUMO_ERROR;
    public final NotificationVariant infoTheme = NotificationVariant.LUMO_CONTRAST;
    public final Notification.Position bottomLeft = Notification.Position.BOTTOM_START;
    public final Notification.Position topCenter = Notification.Position.TOP_CENTER;
}
