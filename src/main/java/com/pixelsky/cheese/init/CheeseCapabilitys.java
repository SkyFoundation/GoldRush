package com.pixelsky.cheese.init;

import com.pixelsky.cheese.capability.cheese.Cheese;
import com.pixelsky.cheese.capability.cheese.CheeseStorage;
import com.pixelsky.cheese.capability.cheese.ICheese;
import com.pixelsky.cheese.capability.haditems.HadItems;
import com.pixelsky.cheese.capability.haditems.HadItemsStorage;
import com.pixelsky.cheese.capability.haditems.IHadItems;
import com.pixelsky.cheese.capability.money.IMoney;
import com.pixelsky.cheese.capability.money.Money;
import com.pixelsky.cheese.capability.money.MoneyStorage;
import com.pixelsky.cheese.capability.shouldgiveitems.IShouldGiveItems;
import com.pixelsky.cheese.capability.shouldgiveitems.ShouldGiveItems;
import com.pixelsky.cheese.capability.shouldgiveitems.ShouldGiveItemsStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CheeseCapabilitys {

	public CheeseCapabilitys() {
		register();
	}
	
	public void register() {
		CapabilityManager.INSTANCE.register(IHadItems.class, new HadItemsStorage(), HadItems.class);
		CapabilityManager.INSTANCE.register(IShouldGiveItems.class, new ShouldGiveItemsStorage(), ShouldGiveItems.class);
		CapabilityManager.INSTANCE.register(ICheese.class, new CheeseStorage(), Cheese.class);
		CapabilityManager.INSTANCE.register(IMoney.class, new MoneyStorage(), Money.class);
	}
	
}
