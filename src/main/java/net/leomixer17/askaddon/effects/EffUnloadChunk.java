package net.leomixer17.askaddon.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.event.Event;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.eclipse.jdt.annotation.Nullable;

public class EffUnloadChunk extends Effect {

    private Expression<Chunk> chunk;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] args, int i, Kleenean arg2, ParseResult arg3)
    {
        this.chunk = (Expression<Chunk>) args[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1)
    {
        return "unload chunk";
    }

    @Override
    protected void execute(Event e)
    {
        final ChunkUnloadEvent event = new ChunkUnloadEvent(this.chunk.getSingle(e));
        Bukkit.getPluginManager().callEvent(event);
        this.chunk.getSingle(e).unload(true);
    }

}
