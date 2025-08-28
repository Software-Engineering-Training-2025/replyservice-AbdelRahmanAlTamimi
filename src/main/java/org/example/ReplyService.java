package org.example;
import java.util.Map;

public class ReplyService {

    private static final Map<String, Map<ReplyType, String>> RESPONSES = Map.of(
            "hi", Map.of(
                    ReplyType.FORMAL, "Hello. How may I assist you today?",
                    ReplyType.FRIENDLY, "Hey there! 😊 How can I help?",
                    ReplyType.CONCISE, "Hello. How can I help?"
            ),
            "hello", Map.of(
                    ReplyType.FORMAL, "Hello. How may I assist you today?",
                    ReplyType.FRIENDLY, "Hi! 👋 What’s up?",
                    ReplyType.CONCISE, "Hello. How can I help?"
            ),
            "how are you", Map.of(
                    ReplyType.FORMAL, "I am functioning properly. How may I assist you?",
                    ReplyType.FRIENDLY, "Doing great! 😄 How can I help?",
                    ReplyType.CONCISE, "I’m good. How can I help?"
            ),
            "i need help", Map.of(
                    ReplyType.FORMAL, "I can assist with that. Please provide more details.",
                    ReplyType.FRIENDLY, "I’ve got you! 🙂 Tell me a bit more.",
                    ReplyType.CONCISE, "Share details; I’ll help."
            ),
            "can you help me with my account", Map.of(
                    ReplyType.FORMAL, "Certainly. Please describe the account issue.",
                    ReplyType.FRIENDLY, "Sure thing! 😊 What’s wrong with the account?",
                    ReplyType.CONCISE, "Describe the account issue…"
            ),
            "thanks", Map.of(
                    ReplyType.FORMAL, "You are welcome.",
                    ReplyType.FRIENDLY, "Anytime! 🙌",
                    ReplyType.CONCISE, "You’re welcome."
            ),
            "bye", Map.of(
                    ReplyType.FORMAL, "Goodbye.",
                    ReplyType.FRIENDLY, "See you later! 👋",
                    ReplyType.CONCISE, "Goodbye."
            ),
            "what is your name", Map.of(
                    ReplyType.FORMAL, "I am your virtual assistant.",
                    ReplyType.FRIENDLY, "I’m your helper bot 🤖",
                    ReplyType.CONCISE, "I’m your assistant."
            )
    );

    private static final Map<ReplyType, String> DEFAULT_RESPONSES = Map.of(
            ReplyType.FORMAL, "Could you clarify your request?",
            ReplyType.FRIENDLY, "Could you tell me more?",
            ReplyType.CONCISE, "Please clarify."
    );

    public String reply(String message, ReplyType type) {
        if (message == null || message.trim().isEmpty()) {
            return "Please say something.";
        }

        if (RESPONSES.containsKey(message.toLowerCase())) {
            return RESPONSES.get(message.toLowerCase()).get(type);
        }

        return DEFAULT_RESPONSES.get(type);
    }
}