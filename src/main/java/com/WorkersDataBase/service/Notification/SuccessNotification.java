package com.WorkersDataBase.service.Notification;

import com.vaadin.flow.component.notification.Notification;

public class SuccessNotification extends NotificationBase{

    public SuccessNotification(String message) {
        Notification notification = Notification.show(message);
        notification.addThemeVariants(successTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(bottomLeft);
    }
}
