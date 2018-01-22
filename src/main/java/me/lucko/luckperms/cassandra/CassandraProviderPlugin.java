package me.lucko.luckperms.cassandra;

import com.google.common.collect.ImmutableSet;

import me.lucko.luckperms.cassandra.dao.CassandraConfig;
import me.lucko.luckperms.cassandra.dao.CassandraDao;
import me.lucko.luckperms.common.plugin.LuckPermsPlugin;
import me.lucko.luckperms.common.storage.dao.AbstractDao;
import me.lucko.luckperms.common.storage.provider.StorageProvider;
import me.lucko.luckperms.common.storage.provider.StorageProviders;

import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;

public class CassandraProviderPlugin extends JavaPlugin implements StorageProvider {

    @Override
    public void onEnable() {
        StorageProviders.register(this);
    }

    @Override
    public AbstractDao provide(LuckPermsPlugin plugin) {
        CassandraConfig config = new CassandraConfig(ImmutableSet.of(new InetSocketAddress("localhost", 9042)), false, "luckperms", "", "", "");
        return new CassandraDao(plugin, config);
    }
}
