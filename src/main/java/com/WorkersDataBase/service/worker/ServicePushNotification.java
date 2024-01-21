package com.WorkersDataBase.service.worker;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.stereotype.Component;

@Component
public class ServicePushNotification{
    private final int notificationTimeDuration = 3000;
    private final NotificationVariant successTheme = NotificationVariant.LUMO_SUCCESS;
    private final NotificationVariant errorTheme = NotificationVariant.LUMO_ERROR;
    private final NotificationVariant infoTheme = NotificationVariant.LUMO_CONTRAST;
    private final Notification.Position bottomLeft = Notification.Position.BOTTOM_START;
    private final Notification.Position topCenter = Notification.Position.TOP_CENTER;

    public void pushSuccess(String message){
        Notification notification = Notification.show(message);
        notification.addThemeVariants(successTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(bottomLeft);
    }

    public void pushError(String message){
        Notification notification = Notification.show(message);
        notification.addThemeVariants(errorTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(topCenter);
    }

    public void pushInfo(String message){
        Notification notification = Notification.show(message);
        notification.addThemeVariants(infoTheme);
        notification.setDuration(notificationTimeDuration);
        notification.setPosition(topCenter);
    }

}
