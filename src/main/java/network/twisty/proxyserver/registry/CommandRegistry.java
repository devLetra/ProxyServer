package network.twisty.proxyserver.registry;

import network.twisty.proxyserver.ProxyPlugin;
import lombok.Data;
import me.saiintbrisson.bungee.command.BungeeFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import me.saiintbrisson.minecraft.command.message.MessageType;
import network.twisty.proxyserver.commands.*;

@Data(staticConstructor = "of")
public class CommandRegistry {

    public ProxyPlugin plugin;

    public void register() {
        BungeeFrame bungeeFrame = new BungeeFrame(plugin);
        MessageHolder messageHolder = bungeeFrame.getMessageHolder();
        messageHolder.setMessage(MessageType.INCORRECT_USAGE, "§cUtilize /{usage}.");
        messageHolder.setMessage(MessageType.NO_PERMISSION, "§cVocê não tem permissão para isso.");
        bungeeFrame.registerCommands(
                new MaintenanceCommand(),
                new StaffCommand(),
                new WebCommand(),
                new StaffChatCommand(),
                new OnlineCommand(),
                new MotdCommand(),
                new LobbyCommand(),
                new InfoCommand(),
                new FindCommand(),
                new AnnouncementCommand(),
                new PingCommand()
        );
    }
}
