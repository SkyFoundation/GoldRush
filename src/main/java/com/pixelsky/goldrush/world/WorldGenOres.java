package com.pixelsky.goldrush.world;

import com.pixelsky.goldrush.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                //地狱
                break;
            case 0:
                //主世界
                generateOverworld(world,random,chunkX,chunkZ);
                break;
            case 1:
                //末地
                break;

        }
    }
    public void generateOverworld(World world, Random rand, int x, int z)
    {
        //dirt ores
    	
        //generateOre(ModBlocks.DIRT_COAL_ORE, world, rand, x, z, 3, 10, 47, 0, 128, Blocks.DIRT);

        //sand ores
    	
    	//      										  				                    最低  最高
    	//													        最少 最多 生成数量
    	
    	
    	//最24嗯
    	
    	//最8嗯
    	
    	
    	
    	
    	
    	
    	
    	//generateOre(ModBlocks.SAND_IRON_ORE, world, rand, x, z, 2, 10, 8, 50, 80, Blocks.SAND);		//ok
    	
    	//generateOre(ModBlocks.SAND_GOLD_ORE, world, rand, x, z, 4, 8, 10, 50, 80, Blocks.SAND);		//ok
    	
    	//generateOre(ModBlocks.SAND_DIAMOND_ORE, world, rand, x, z, 2, 6, 6, 50, 80, Blocks.SAND);	//ok
    	
    	//generateOre(ModBlocks.SAND_COAL_ORE, world, rand, x, z, 3, 5, 8, 50, 80, Blocks.SAND);	//ok
    	
    	
    	
    	generateOre(ModBlocks.SAND_EMERALD_ORE, world, rand, x, z, 1, 1, 5, 50, 80, Blocks.SAND);	//ok?
    	//求要矿物的大小是1
    	//你修吧
    	
    	
    	//generateOre(ModBlocks.SAND_LAPIS_ORE, world, rand, x, z, 4, 6, 6, 50, 80, Blocks.SAND);	//大海低下 ok？
    	
    	//generateOre(ModBlocks.SAND_REDSTONE_ORE, world, rand, x, z, 3, 10, 6, 50, 80, Blocks.SAND);
       
        
        
    	
    	
    	
    	
    	
    	
    	
        
     
        
        
        /*--------------------------------------------------------------------------------------------*/
        
        
        
        
        
        
        /*--------------------------------------------------------------------------------------------*/
        /*
        generateOre(ModBlocks.DIRT_COAL_ORE, world, rand, x, z, 4, 6, 8, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_DIAMOND_ORE, world, rand, x, z, 3, 5, 6, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_EMERALD_ORE, world, rand, x, z, 1, 3, 4, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_GOLD_ORE, world, rand, x, z, 2, 5, 10, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_IRON_ORE, world, rand, x, z, 2, 6, 8, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_LAPIS_ORE, world, rand, x, z, 4, 8, 8, 40, 100, Blocks.DIRT);
        
        generateOre(ModBlocks.DIRT_REDSTONE_ORE, world, rand, x, z, 4, 6, 8, 40, 100, Blocks.DIRT);
        */
        /*--------------------------------------------------------------------------------------------*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //3;minecraft:bedrock,90*minecraft:sand;2;village,biome_1,decoration,stronghold,mineshaft,dungeon
        
       //generateOre(ModBlocks.SAND_COAL_ORE, world, rand, x, z, 3, 10, 47, 0, 128, Blocks.SAND);
        
        //80/40
        
        
        
        
        
        
        
        
    }
    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
        int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, BlockMatcher.forBlock(generateIn));
        for(int i = 0; i < chance; i++) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            BlockPos orePos = new BlockPos(xRand, yRand, zRand);
            gen.generate(world, random, orePos);
        }
    }
    
    
  
}
