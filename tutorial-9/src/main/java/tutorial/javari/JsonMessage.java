package tutorial.javari;

class JsonMessage {
    private final String msgType;
    private final String message;

    private JsonMessage(String msgType, String message) {
        this.msgType = msgType;
        this.message = message;
    }

    public static JsonMessage getNotFoundMessage(int id) {
        return new JsonMessage("warning",
                "Sorry, animal with id = " + id + " not found.");
    }

    public static JsonMessage getDatabaseEmptyMessage() {
        return new JsonMessage("warning",
                "Sorry, we have no animals yet.");
    }

    public static JsonMessage getSuccessDeleteMessage() {
        return new JsonMessage("success",
                "We have successfully de-registered the animal. "
                        + "So take this data in case you need it back.");
    }

    public static JsonMessage getSuccessAddMessage() {
        return new JsonMessage("success",
                "We have successfully registered the animal. "
                        + "Here we provided the registered data.");
    }

    public String getMessage() {
        return message;
    }

    public String getMsgType() {
        return msgType;
    }

}