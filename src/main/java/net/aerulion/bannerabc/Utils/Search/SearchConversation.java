package net.aerulion.bannerabc.Utils.Search;

import java.util.UUID;
import net.aerulion.bannerabc.Main;
import net.aerulion.bannerabc.Utils.Utils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;

public class SearchConversation extends StringPrompt {

  @Override
  public String getPromptText(ConversationContext con) {
    ((Player) con.getForWhom()).closeInventory();
    return "Tippe deine Suchanfrage in den Chat. Schreibe '§astop§7' um den Suchvorgang abzubrechen. Die Suchanfrage endet nach 30 Sekunden.";
  }

  @Override
  public Prompt acceptInput(ConversationContext con, String searchinput) {

    UUID u = ((Player) con.getForWhom()).getUniqueId();
    Utils.searchpage.put(u, 1);
    Utils.latestsearch.put(u, searchinput);
    Utils.CurrentCat.put(u, null);
    Main.plugin.getServer().getScheduler()
        .runTaskLater(Main.plugin, () -> Search.SearchInv((Player) con.getForWhom()), 1L);
    return null;

  }
}