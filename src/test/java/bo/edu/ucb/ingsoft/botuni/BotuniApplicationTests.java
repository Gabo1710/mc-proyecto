package bo.edu.ucb.ingsoft.botuni;

import bo.edu.ucb.ingsoft.botuni.ChatBot.BotUniLongPolling;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BotuniApplicationTests {

	@Autowired
	private ApplicationContext appContext;

	@Test
	void sayHello() {
		BotUniLongPolling bot = new BotUniLongPolling(appContext, true);
		// Invoco al bot con un mensaje
		bot.onUpdateReceived(createUpdate("Hello"));
		// Reviso cuantos mensaje me retorna.
		List<BotApiMethod> messages =  bot.getTestMessages();
		assertEquals(1, messages.size(), "El chat devolvió mas de un mensaje." );
		// Obtener el mensaje
		SendMessage sendMessage = (SendMessage) messages.get(0);
		assertTrue(sendMessage.getText().contains("MENU PRINCIPAL"),"Se obtuvo un proceso diferente a menú principal");
		// Limpiamos los mensajes
		bot.getTestMessages().clear();


		// Ya recibi menu principal envio opción 1
		bot.onUpdateReceived(createUpdate("1"));
		assertEquals(1, messages.size(), "El chat devolvió mas de un mensaje." );
		sendMessage = (SendMessage) messages.get(0);
		assertTrue(sendMessage.getText().contains("Su horario es el siguiente:"), "Proceso correcto");
		bot.getTestMessages().clear();


		// Vuelvo a enviar hello
		bot.onUpdateReceived(createUpdate("hello"));
		assertEquals(1, messages.size(), "El chat devolvió mas de un mensaje." );
		sendMessage = (SendMessage) messages.get(0);
		assertTrue(sendMessage.getText().contains("MENÚ PRINCIPAL"), "Se obtuvo un proceso diferetena a Menu Principal");
	}

	private Update createUpdate(String text) {
		Update update = new Update();
		Message message = new Message();
		message.setText(text);
		Chat chat = new Chat();
		chat.setId(123456789L);
		message.setChat(chat);
		update.setMessage(message);
		return update;
	}

}
