package com.pixelsky.cheese.world.gen;

import com.pixelsky.cheese.init.CheeseBiomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class MapGenCheeseVillage extends MapGenStructure {
	public static List<Biome> VILLAGE_SPAWN_BIOMES = Arrays
			.<Biome>asList(new Biome[] { CheeseBiomes.CHEESE_DIMENSION_BIOME });
	/** None */
	private int size;
	private int distance;
	private final int minTownSeparation;

	public MapGenCheeseVillage() {
		this.distance = 32;
		this.minTownSeparation = 8;
	}

	public MapGenCheeseVillage(Map<String, String> map) {
		this();

		for (Entry<String, String> entry : map.entrySet()) {
			if (((String) entry.getKey()).equals("size")) {
				this.size = MathHelper.getInt((String) entry.getValue(), this.size, 0);
			} else if (((String) entry.getKey()).equals("distance")) {
				this.distance = MathHelper.getInt((String) entry.getValue(), this.distance, 9);
			}
		}
	}

	public String getStructureName() {
		return "CheeseVillage";
	}



	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
		int i = chunkX;
		int j = chunkZ;

		if (chunkX < 0) {
			chunkX -= this.distance - 1;
		}

		if (chunkZ < 0) {
			chunkZ -= this.distance - 1;
		}

		int k = chunkX / this.distance;
		int l = chunkZ / this.distance;
		Random random = this.world.setRandomSeed(k, l, 10387312);
		k = k * this.distance;
		l = l * this.distance;
		k = k + random.nextInt(this.distance - 8);
		l = l + random.nextInt(this.distance - 8);

		if (i == k && j == l) {
			boolean flag = this.world.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 0,
					VILLAGE_SPAWN_BIOMES);

			if (flag) {
				return true;
			}
		}

		return false;
	}

	@Nullable
	@Override
	public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
		this.world = worldIn;
		return findNearestStructurePosBySpacing(worldIn, this, pos, this.distance, 8, 10387312, false, 100,
				findUnexplored);
	}


	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		return new MapGenCheeseVillage.Start(this.world, this.rand, chunkX, chunkZ, this.size);
	}

	public static class Start extends StructureStart {
		/** well ... thats what it does */
		private boolean hasMoreThanTwoComponents;

		public Start() {
		}

		public Start(World worldIn, Random rand, int x, int z, int size) {
			super(x, z);
			List<StructureCheeseVillagePieces.PieceWeight> list = StructureCheeseVillagePieces
					.getStructureVillageWeightedPieceList(rand, size);
			StructureCheeseVillagePieces.Start structurevillagepieces$start = new StructureCheeseVillagePieces.Start(
					worldIn.getBiomeProvider(), 0, rand, (x << 4) + 2, (z << 4) + 2, list, size);
			this.components.add(structurevillagepieces$start);
			structurevillagepieces$start.buildComponent(structurevillagepieces$start, this.components, rand);
			List<StructureComponent> list1 = structurevillagepieces$start.pendingRoads;
			List<StructureComponent> list2 = structurevillagepieces$start.pendingHouses;

			while (!list1.isEmpty() || !list2.isEmpty()) {
				if (list1.isEmpty()) {
					int i = rand.nextInt(list2.size());
					StructureComponent structurecomponent = (StructureComponent) list2.remove(i);
					structurecomponent.buildComponent(structurevillagepieces$start, this.components, rand);
				} else {
					int j = rand.nextInt(list1.size());
					StructureComponent structurecomponent2 = (StructureComponent) list1.remove(j);
					structurecomponent2.buildComponent(structurevillagepieces$start, this.components, rand);
				}
			}

			this.updateBoundingBox();
			int k = 0;

			for (StructureComponent structurecomponent1 : this.components) {
				if (!(structurecomponent1 instanceof StructureCheeseVillagePieces.Road)) {
					++k;
				}
			}

			this.hasMoreThanTwoComponents = k > 2;
		}

		/**
		 * currently only defined for Villages, returns true if Village has more
		 * than 2 non-road components
		 */
		public boolean isSizeableStructure() {
			return this.hasMoreThanTwoComponents;
		}

		public void writeToNBT(NBTTagCompound tagCompound) {
			super.writeToNBT(tagCompound);
			tagCompound.setBoolean("Valid", this.hasMoreThanTwoComponents);
		}

		public void readFromNBT(NBTTagCompound tagCompound) {
			super.readFromNBT(tagCompound);
			this.hasMoreThanTwoComponents = tagCompound.getBoolean("Valid");
		}
	}
}