package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create(config -> {
            // Включаем логгирование при разработке
            config.bundledPlugins.enableDevLogging();
        });

//        List<User> users = List.of("John", "Mark", "Ann");
//        var data = new Data();

        // Описываем, что будет происходить при GET запросе на адрес /
        // Метод json() кодирует тело ответа в JSON строку и вызывает метод result()
        // Дополнительно устанавливает в ответе заголовок content type со значением json
        app.get("/phones", ctx -> ctx.json(Data.getPhones()));
        app.get("/domains", ctx -> ctx.json(Data.getDomains()));
        // Возвращаем настроенное приложение
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
