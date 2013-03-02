package sprites;

import info.constants.SpritesConstants;

public class Sprites {
	public static Sprite[][] objects = SpriteSheetLoader.cutTiles(
			"/Objects/objects1.png", 16, 16);
	public static Sprite[][] buildings = SpriteSheetLoader.cutTiles(
			"/Buildings/buildings.png", 16, 16);
	public static Sprite[][] terrain = SpriteSheetLoader.cutTiles(
			"/Terrain/terrain.png", SpritesConstants.terrainTileWidth,
			SpritesConstants.terrainTileHeight);
	public static Sprite[][] level = SpriteSheetLoader.cutTiles(
			"/Level/level.png", SpritesConstants.levelWidth, SpritesConstants.levelHeight);
	public static Sprite[][] player = SpriteSheetLoader.cutTiles(
			"/Characters/chars.png", SpritesConstants.playerTileWidth,
			SpritesConstants.playerTileHeight);

}
