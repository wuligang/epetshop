/**
 *
 */
package cn.it.epetShop.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.it.epetShop.dao.PetDao;
import cn.it.epetShop.dao.PetOwnerDao;
import cn.it.epetShop.dao.PetStoreDao;
import cn.it.epetShop.dao.impl.PetDaoImpl;
import cn.it.epetShop.dao.impl.PetOwnerDaoImpl;
import cn.it.epetShop.dao.impl.PetStoreDaoImpl;
import cn.it.epetShop.entity.Account;
import cn.it.epetShop.entity.Pet;
import cn.it.epetShop.entity.PetOwner;
import cn.it.epetShop.entity.PetStore;
import cn.it.epetShop.service.PetOwnerService;
import cn.it.epetShop.service.PetStoreFactory;
import cn.it.epetShop.service.PetStoreService;
import cn.it.epetShop.service.impl.PetOwnerServiceImpl;
import cn.it.epetShop.service.impl.PetStoreFactoryImpl;
import cn.it.epetShop.service.impl.PetStoreServiceImpl;

/**
 *  入口类
 *
 */
public class Main {

    /**
     * @param args
     * void 系统入口方法
     */
    public static void main(String[] args) {
        Main.startPetShop();
    }

    /**
     * 系统启动
     */
    public static void startPetShop() {
        System.out.println(" 宠物商店启动");
        System.out.println("Wonderland醒来,所有宠物从MySQL中醒来");
        System.out
                .println("****************************************************");
        PetDao petDao = new PetDaoImpl();
        List<Pet> petList = petDao.getAllPet();
        System.out.println("序号\t" + "宠物名称\t");
        for (int i = 0; i < petList.size(); i++) {
            Pet pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        System.out.println("所有宠物主人从MySQL中醒来");
        PetOwnerDao ownerDao = new PetOwnerDaoImpl();
        List<PetOwner> ownerList = ownerDao.getAllOwner();
        System.out
                .println("****************************************************");
        System.out.println("序号\t" + "主人姓名\t");
        for (int i = 0; i < ownerList.size(); i++) {
            PetOwner owner = ownerList.get(i);
            System.out.println((i + 1) + "\t" + owner.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        System.out.println("所有宠物商店从MySQL中醒来");
        System.out
                .println("****************************************************");
        PetStoreDao storeDao = new PetStoreDaoImpl();
        List<PetStore> storeList = storeDao.getAllStore();
        System.out.println("序号\t" + "宠物商店名称\t");
        for (int i = 0; i < storeList.size(); i++) {
            PetStore store = storeList.get(i);
            System.out.println((i + 1) + "\t" + store.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        Scanner input = new Scanner(System.in);
        System.out.println("请选择输入登录模式，输入1为宠物主人登录，输入2为宠物商店登录");
        boolean type = true;
        String num;
        while (type) {
            num = input.next();
            if ("1".equals(num)) {
                Main.ownerLogin();
                type = false;
            } else if ("2".equals(num)) {
                Main.storeLogin();
                type = false;
            } else {
                System.out.println("输入有误，请按照指定规则输入");
                System.out.println("请选择登录模式，输入1为宠物主人登录，输入2为宠物商店登录");
                type = true;
            }
        }
    }

    /**
     * 宠物主人登录方法
     */
    public static PetOwner ownerLogin() {
        Scanner input = new Scanner(System.in);
        PetOwnerServiceImpl petOwner = new PetOwnerServiceImpl();
        PetOwner Owner = petOwner.login();
        boolean reg = true;
        while (reg) {
            if (null == Owner) {
                System.out.println("登录失败，请确认您的用户名和密码后重新输入");
                Owner = petOwner.login();
                reg = true;
            } else {
                reg = false;
                System.out.println("登录成功，您可以购买和卖出宠物，如果您想购买宠物请输入1，如果想卖出宠物请输入2");
                System.out.println("1：购买宠物");
                System.out.println("2：卖出宠物");
                boolean type = true;
                while (type) {
                    int num = input.nextInt();
                    if (1 == num) {

                        Main.ownerBuy(Owner);
                        type = false;
                    } else if (2 == num) {
                        Main.ownerSell(Owner);
                        type = false;
                    } else {
                        System.out.println("输入有误,请重新输入");
                        type = true;
                    }
                }
            }
        }

        return Owner;
    }

    /**
     * 宠物商店登录方法
     */
    public static PetStore storeLogin() {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        PetStore store = petStore.login();
        System.out.println("登录成功，可以进行如下操作");
        System.out.println("1：购买宠物");
        System.out.println("2：卖出宠物");
        System.out.println("3：培育宠物");
        System.out.println("4：查询待售宠物");
        System.out.println("5：查看商店结余");
        System.out.println("6：查看商店账目");
        System.out.println("7：开宠物商店");
        System.out.println("请根据需要执行的操作，选择序号输入，退出请输入0");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("退出成功");
                    type = false;
                    break;
                case 1:
                    Main.storeBuy(store);
                    type = false;
                    break;
                case 2:
                    Main.storeSell(store);
                    type = false;
                    break;
                case 3:
                    Main.storeBread();
                    type = false;
                    break;
                case 4:
                    Main.queryPetStock(store.getId());
                    type = false;
                    break;
                case 5:
                    Main.queryStoreBalance(store);
                    type = false;
                    break;
                case 6:
                    Main.getAccount(store.getId());
                    type = false;
                    break;
                case 7:
                    Main.createPetStore();
                    type = false;
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
                    type = true;
                    break;
            }
        }
        return store;
    }

    /**
     * 查询商店结余
     */
    public static void queryStoreBalance(PetStore petStore) {
        double balance = petStore.getBalance();
        System.out.println(petStore.getName() + "宠物商店的结余为:" + balance);
    }

    /**
     * 查询待售宠物
     */
    public static void queryPetStock(long storeId) {
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetsInstock(storeId);
        System.out.println("序号\t" + "宠物名称\t" + " 类型\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
    }

    /**
     * 宠物商店购买宠物
     */
    public static void storeBuy(PetStore store) {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetSelling();
        System.out.println("-------以下是宠物主人正在出售的宠物-------");
        System.out.println("序号\t" + "宠物名称\t" + " 类型\t" + "\t元宝数\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            double price = petStore.charge(pet);// 获得到宠物的价格
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
        }
        System.out.println("-------请选择要购买哪个一个宠物，并输入选择项的序号-------");
        int num = input.nextInt();
        pet = petList.get(num - 1);
        petStore.buy(pet);
    }

    /**
     * 宠物商店出售宠物
     */
    public static void storeSell(PetStore store) {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetsInstock(store.getId());
        System.out.println("-------以下是宠物商店正在出售的宠物-------");
        System.out.println("序号\t" + "宠物名称\t" + "类型\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
        System.out.println("---------请选择要购买的宠物序号--------");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            if ((num - 1) < petList.size() && (num - 1) >= 0) {
                pet = petList.get(num - 1);
                System.out.println("------要卖出的宠物信息如下------");
                System.out.println("宠物名字叫：" + pet.getName() + " 宠物类别是："
                        + pet.getTypeName());
                System.out.println("请确认是否卖出，y代表卖出，n代表不卖");
                String code = input.next();
                if (null != code) {
                    if ("y".equals(code)) {
                        System.out
                                .println("------下面是现有宠物主人买家，请选择您要卖给买家序号------");
                        List<PetOwner> ownerList = new ArrayList<PetOwner>();
                        PetOwnerDao ownerDao = new PetOwnerDaoImpl();
                        ownerList = ownerDao.getAllOwner();
                        PetOwner petOwner = null;
                        System.out.println("序号\t" + "宠物主人姓名\t");
                        for (int i = 0; i < ownerList.size(); i++) {
                            petOwner = ownerList.get(i);
                            System.out.println((i + 1) + "\t" + petOwner.getName() + "\t");
                        }
                        num = input.nextInt();
                        if ((num - 1) < ownerList.size() && (num - 1) >= 0) {
                            petOwner = ownerList.get(num - 1);
                        }
                        pet.setOwnerId(petOwner.getId());
                        petStore.sell(pet);
                    } else if ("n".equals(type)) {
                        System.out
                                .println("--------您选择放弃本次交易，希望您再次光顾----------");

                    } else {
                        System.out.println("--------您的输入有误----------");
                    }
                }
                type = true;
            } else {
                System.out.println("输入有误，请按照序号重新输入");
                type = false;
            }
            type = false;// 标识符更改为false，退出系统
        }
    }

    /**
     * 宠物商店培育宠物
     */
    public static void storeBread() {
        PetStoreService petStore = new PetStoreServiceImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要培育宠物的类型");
        String petType = input.next();
        petStore.bread(petType);
    }

    /**
     * 创建宠物商店
     */
    public static void createPetStore() {
        PetStoreFactory storeFactory = new PetStoreFactoryImpl();
        storeFactory.createPetStore();
    }


    /**
     * 宠物主人购买宠物
     */
    public static void ownerBuy(PetOwner owner) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------请输入选择要购买范围：只输入选择项的序号--------");
        System.out.println("1：购买库存宠物");
        System.out.println("2：购买新培育宠物");
        PetStoreService petStore = new PetStoreServiceImpl();
        PetOwnerService petOwner = new PetOwnerServiceImpl();
        Pet pet = null;
        int num = input.nextInt();
        List<Pet> petList = null;
        // num为1时购买库存宠物
        boolean type = true;
        while (type) {
            if (num == 1) {
                petList = petStore.getPetsInstock(0);
                System.out.println("-------以下是库存宠物-------");
                System.out.println("序号\t" + "宠物名称\t" + "类型\t" + "\t元宝数\t");
                for (int i = 0; i < petList.size(); i++) {
                    pet = petList.get(i);
                    double price = petStore.charge(pet);// 获得到宠物的价格
                    System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
                }
                System.out.println("-------请选择要购买哪个一个宠物，并输入选择项的序号-------");
                num = input.nextInt();
                pet = petList.get(num - 1);
                pet.setOwnerId(owner.getId());
                petOwner.buy(pet);
                type = false;
                // num为2时购买新培育宠物
            } else if (num == 2) {
                System.out.println("-------以下是库存宠物-------");
                System.out.println("序号\t" + "宠物名称\t" + "类型\t" + "\t元宝数\t");
                petList = petStore.getPetsBread();
                for (int i = 0; i < petList.size(); i++) {
                    pet = petList.get(i);
                    double price = petStore.charge(pet);// 获得到宠物的价格
                    System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
                }
                System.out.println("-------请选择要购买哪个一个宠物，并输入选择项的序号-------");
                String count = input.next();
                if (count.matches("[0-9]*")) {
                    num = Integer.parseInt(count);
                    pet = petList.get(num - 1);
                    pet.setOwnerId(owner.getId());
                    petOwner.buy(pet);
                }
                type = false;
            } else {
                System.out.println("您的输入有误，请安提示输入");
                type = true;
            }
        }
    }

    /**
     * 宠物主人向宠物商店出售自己宠物
     */
    public static void ownerSell(PetOwner petOwner) {
        Scanner input = new Scanner(System.in);
        PetOwnerService owner = new PetOwnerServiceImpl();
        System.out.println("---------我的宠物列表--------");
        List<Pet> petList = owner.getMyPet(petOwner.getId());
        System.out.println("序号\t" + "宠物名称\t" + "类型\t");
        for (int i = 0; i < petList.size(); i++) {
            Pet pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
        System.out.println("---------请选择要出售的宠物序号--------");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            if ((num - 1) < petList.size() && (num - 1) >= 0) {
                Pet pet = petList.get(num - 1);
                System.out.println("------您要卖出的宠物信息如下------");
                System.out.println("宠物名字叫：" + pet.getName() + " 宠物类别是："
                        + pet.getTypeName());
                System.out.println("请确认是否卖出，y代表卖出，n代表不卖");
                String code = input.next();
                if (null != code) {
                    if ("y".equals(code)) {
                        System.out.println("------下面是现有宠物商店，请选择您要卖给买家序号------");
                        List<PetStore> storeList = new ArrayList<PetStore>();
                        PetStoreDao storeDao = new PetStoreDaoImpl();
                        storeList = storeDao.getAllStore();
                        PetStore petStore = null;
                        System.out.println("序号\t" + "宠物商店名字\t");
                        for (int i = 0; i < storeList.size(); i++) {
                            petStore = storeList.get(i);
                            System.out.println((i + 1) + "\t" + petStore.getName() + "\t");
                        }
                        num = input.nextInt();
                        if ((num - 1) < storeList.size() && (num - 1) >= 0) {
                            petStore = storeList.get(num - 1);
                        }
                        pet.setStoreId(petStore.getId());
                        owner.sell(pet);
                    } else if ("n".equals(type)) {
                        System.out
                                .println("--------您选择放弃本次交易，希望您再次光顾----------");

                    } else {
                        System.out.println("--------您的输入有误----------");
                    }
                }
                type = true;
            } else {
                System.out.println("输入有误，请按照序号重新输入");
                type = false;
            }
            type = false;// 标识符更改为false，退出系统
        }
    }

    /**
     * 查看商店帐目
     */
    public static void getAccount(long storeId) {
        PetStoreService store = new PetStoreServiceImpl();
        List<Account> list = store.account(storeId);
        for (int i = 0; i < list.size(); i++) {
            Account account = list.get(i);
            String type = null;
            if (1 == account.getDealType()) {
                type = "商店卖给宠物主人";
            } else if (2 == account.getDealType()) {
                type = "宠物主人卖给商店";
            } else {
                type = "宠物主人之间交易";
            }
            System.out.println("第" + (i + 1) + "笔交易,交易类型为：" + type + "，交易金额是:"
                    + account.getPrice() + "个元宝");
        }
    }

}
