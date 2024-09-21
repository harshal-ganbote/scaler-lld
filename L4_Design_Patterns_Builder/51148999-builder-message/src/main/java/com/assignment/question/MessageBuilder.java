import java.lang.module.ModuleDescriptor.Builder;

import com.assignment.question.MessageType;
import com.assignment.question.WithBuilder;

@WithBuilder
public class MessageBuilder {

  private MessageType messageType;
  private String content;
  private String sender;
  private String recipient;
  private boolean isDelivered;
  private long timestamp;

  private MessageBuilder(Builder builder) {
    this.messageType = builder.messageType;
    this.content = builder.content;
    this.sender = builder.sender;
    this.recipient = builder.recipient;
    this.isDelivered = builder.isDelivered;
    this.timestamp = builder.timestamp;
  }

  public static Builder getBuilder() {
    return new Builder();
  }

  public MessageType getMessageType() {
    return messageType;
  }

  public String getContent() {
    return content;
  }

  public String getSender() {
    return sender;
  }

  public String getRecipient() {
    return recipient;
  }

  public boolean isDelivered() {
    return isDelivered;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public static class builder {
    MessageType messageType;
    String content;
    String sender;
    String recipient;
    boolean isDelivered;
    long timestamp;

    public Builder setMessageType(MessageType messageType) {
      this.messageType = messageType;
      return this;
    }

    public Builder setContent(String content) {
      this.content = content;
      return this;
    }

    public Builder setSender(String sender) {
      this.sender = sender;
      return this;
    }

    public Builder setRecipient(String recipient) {
      this.recipient = recipient;
      return this;
    }

    public Builder setDelivered(boolean isDelivered) {
      this.isDelivered = isDelivered;
      return this;
    }

    public Builder setTimestamp(long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public MessageBuilder build() {
      return new MessageBuilder(this);
    }

  }
}
