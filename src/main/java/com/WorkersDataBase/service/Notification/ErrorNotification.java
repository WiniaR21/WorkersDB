package com.WorkersDataBase.service.Notification;

import com.vaadin.flow.component.notification.Notification;

public class ErrorNotification extends NotificationBase{
    public ErrorNotification(String message) {
        Notification notification = Notification.show(message);
        notification.addThemeVariants(errorTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(topCenter);
    }
}
