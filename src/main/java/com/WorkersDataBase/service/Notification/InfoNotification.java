package com.WorkersDataBase.service.Notification;

import com.vaadin.flow.component.notification.Notification;

public class InfoNotification extends NotificationBase{
    public InfoNotification(String message) {
        Notification notification = Notification.show(message);
        notification.addThemeVariants(infoTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(topCenter);
    }
}
