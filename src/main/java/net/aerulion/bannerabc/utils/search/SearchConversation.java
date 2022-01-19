package net.aerulion.bannerabc.utils.search;

import java.util.UUID;
import net.aerulion.bannerabc.Main;
import net.aerulion.bannerabc.utils.Utils;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SearchConversation extends StringPrompt {

  @Override
  public @NotNull String getPromptText(final @NotNull ConversationContext context) {
    ((Player) context.getForWhom()).closeInventory();
    return "Tippe deine Suchanfrage in den Chat. Schreibe '§astop§7' um den Suchvorgang abzubrechen. Die Suchanfrage endet nach 30 Sekunden.";
  }

  @Override
  public Prompt acceptInput(final @NotNull ConversationContext context, final String input) {

    final @NotNull UUID u = ((Player) context.getForWhom()).getUniqueId();
    Utils.SEARCH_PAGE.put(u, 1);
    Utils.LATEST_SEARCH.put(u, input);
    Utils.CURRENT_CAT.put(u, null);
    Main.plugin.getServer().getScheduler()
        .runTaskLater(Main.plugin, () -> Search.searchInv((Player) context.getForWhom()), 1L);
    return null;

  }
}