plugins {
    `java-library`
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
}

group = "net.aerulion"
version = "1.5.0"

bukkit {
    name = "BannerABC"
    main = "net.aerulion.bannerabc.Main"
    version = getVersion().toString()
    author = "aerulion"
    apiVersion = "1.18"
    commands {
        register("bannerabc") {
            description = "BannerABC öffnen."
            aliases = listOf("babc", "abc")
        }
        register("bannerdatabase") {
            description = "BannerDatabase öffnen."
            aliases = listOf("bdatabase", "bd")
        }
        register("bannerdatabasecategory") {
            description = "BannerDatabase öffnen."
            aliases = listOf("bdatabasecategory", "bdc")
        }
        register("bdreload") {
            description = "BannerDatabase reloaden."
        }
        register("bdhelp") {
            description = "Hilfe anzeigen."
        }
        register("bdmigrate") {
            description = "Datenbank migrieren."
        }
    }
    permissions {
        register("bannerabc.use") {
            description = "Erlaubt dem Spieler das BannerABC zu nutzen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.database") {
            description = "Erlaubt dem Spieler die BannerDatabase zu nutzen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.addbanner") {
            description = "Erlaubt dem Spieler Banner zur BannerDatabase hinzuzufügen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.removebanner") {
            description = "Erlaubt dem Spieler Banner von der BannerDatabase zu entfernen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.addcategory") {
            description = "Erlaubt dem Spieler Kategorien zur BannerDatabase hinzuzufügen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.removecategory") {
            description = "Erlaubt dem Spieler Kategorien von der BannerDatabase zu entfernen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.setcategoryitem") {
            description = "Erlaubt dem Spieler das Kategorie-Item zu ändern."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.changebannercategory") {
            description = "Erlaubt dem Spieler die Kategorie eines Banners zu ändern."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.renamecategory") {
            description = "Erlaubt dem Spieler eine Kategorie umzubenennen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.reload") {
            description = "Erlaubt dem Spieler das Plugin zu reloaden."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.help") {
            description = "Erlaubt dem Spieler das Hilfefenster zu sehen."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
        register("bannerabc.migrate") {
            description = "Erlaubt dem Spieler die Datenbank zu migrieren."
            default = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default.OP
        }
    }
}
