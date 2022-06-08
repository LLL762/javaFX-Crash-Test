package com.example.login.component.builder;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.List;

/**
 * 08/06/2022.
 *
 * @author Laurent Lamiral
 */
public class CharacterTreeBuilder {

    private static final String FOLDER_PATH = "/images/icons/tree-view/";

    private CharacterTreeBuilder() {
    }


    public static void build(TreeView<String> treeView) {

        final TreeItem<String> rootItem = new TreeItem<>("Character");


        final List<TreeItem<String>> rootChildren = List.of(
                new TreeItem<>("Warrior"),
                new TreeItem<>("Cleric"),
                new TreeItem<>("Rogue"),
                new TreeItem<>("Mage", ImageViewBuilder.buildIcon(FOLDER_PATH + "mage.png"))
        );

        rootChildren.get(0).getChildren().addAll(
                List.of(
                        new TreeItem<>("Berserker"),
                        new TreeItem<>("Barbarian"),
                        new TreeItem<>("Samurai")
                )

        );


        rootChildren.get(1).getChildren().addAll(
                List.of(
                        new TreeItem<>("Cleric of Macron"),
                        new TreeItem<>("Cleric of Melenchon"),
                        new TreeItem<>("Cleric of LePen")
                )

        );
        rootChildren.get(2).getChildren().addAll(
                List.of(
                        new TreeItem<>("Assassin"),
                        new TreeItem<>("Acrobat"),
                        new TreeItem<>("Politician")
                )

        );
        rootChildren.get(3).getChildren().addAll(
                List.of(
                        new TreeItem<>("Sorcerer"),
                        new TreeItem<>("Scholar")
                )

        );


        rootItem.getChildren().addAll(rootChildren);
        treeView.setRoot(rootItem);


    }


}
