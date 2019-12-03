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
 *  �����
 *
 */
public class Main {

    /**
     * @param args
     * void ϵͳ��ڷ���
     */
    public static void main(String[] args) {
        Main.startPetShop();
    }

    /**
     * ϵͳ����
     */
    public static void startPetShop() {
        System.out.println(" �����̵�����");
        System.out.println("Wonderland����,���г����MySQL������");
        System.out
                .println("****************************************************");
        PetDao petDao = new PetDaoImpl();
        List<Pet> petList = petDao.getAllPet();
        System.out.println("���\t" + "��������\t");
        for (int i = 0; i < petList.size(); i++) {
            Pet pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        System.out.println("���г������˴�MySQL������");
        PetOwnerDao ownerDao = new PetOwnerDaoImpl();
        List<PetOwner> ownerList = ownerDao.getAllOwner();
        System.out
                .println("****************************************************");
        System.out.println("���\t" + "��������\t");
        for (int i = 0; i < ownerList.size(); i++) {
            PetOwner owner = ownerList.get(i);
            System.out.println((i + 1) + "\t" + owner.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        System.out.println("���г����̵��MySQL������");
        System.out
                .println("****************************************************");
        PetStoreDao storeDao = new PetStoreDaoImpl();
        List<PetStore> storeList = storeDao.getAllStore();
        System.out.println("���\t" + "�����̵�����\t");
        for (int i = 0; i < storeList.size(); i++) {
            PetStore store = storeList.get(i);
            System.out.println((i + 1) + "\t" + store.getName() + "\t");
        }
        System.out
                .println("****************************************************");
        System.out.print("\n");
        Scanner input = new Scanner(System.in);
        System.out.println("��ѡ�������¼ģʽ������1Ϊ�������˵�¼������2Ϊ�����̵��¼");
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
                System.out.println("���������밴��ָ����������");
                System.out.println("��ѡ���¼ģʽ������1Ϊ�������˵�¼������2Ϊ�����̵��¼");
                type = true;
            }
        }
    }

    /**
     * �������˵�¼����
     */
    public static PetOwner ownerLogin() {
        Scanner input = new Scanner(System.in);
        PetOwnerServiceImpl petOwner = new PetOwnerServiceImpl();
        PetOwner Owner = petOwner.login();
        boolean reg = true;
        while (reg) {
            if (null == Owner) {
                System.out.println("��¼ʧ�ܣ���ȷ�������û������������������");
                Owner = petOwner.login();
                reg = true;
            } else {
                reg = false;
                System.out.println("��¼�ɹ��������Թ�����������������빺�����������1���������������������2");
                System.out.println("1���������");
                System.out.println("2����������");
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
                        System.out.println("��������,����������");
                        type = true;
                    }
                }
            }
        }

        return Owner;
    }

    /**
     * �����̵��¼����
     */
    public static PetStore storeLogin() {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        PetStore store = petStore.login();
        System.out.println("��¼�ɹ������Խ������²���");
        System.out.println("1���������");
        System.out.println("2����������");
        System.out.println("3����������");
        System.out.println("4����ѯ���۳���");
        System.out.println("5���鿴�̵����");
        System.out.println("6���鿴�̵���Ŀ");
        System.out.println("7���������̵�");
        System.out.println("�������Ҫִ�еĲ�����ѡ��������룬�˳�������0");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("�˳��ɹ�");
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
                    System.out.println("��������,����������");
                    type = true;
                    break;
            }
        }
        return store;
    }

    /**
     * ��ѯ�̵����
     */
    public static void queryStoreBalance(PetStore petStore) {
        double balance = petStore.getBalance();
        System.out.println(petStore.getName() + "�����̵�Ľ���Ϊ:" + balance);
    }

    /**
     * ��ѯ���۳���
     */
    public static void queryPetStock(long storeId) {
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetsInstock(storeId);
        System.out.println("���\t" + "��������\t" + " ����\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
    }

    /**
     * �����̵깺�����
     */
    public static void storeBuy(PetStore store) {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetSelling();
        System.out.println("-------�����ǳ����������ڳ��۵ĳ���-------");
        System.out.println("���\t" + "��������\t" + " ����\t" + "\tԪ����\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            double price = petStore.charge(pet);// ��õ�����ļ۸�
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
        }
        System.out.println("-------��ѡ��Ҫ�����ĸ�һ�����������ѡ��������-------");
        int num = input.nextInt();
        pet = petList.get(num - 1);
        petStore.buy(pet);
    }

    /**
     * �����̵���۳���
     */
    public static void storeSell(PetStore store) {
        Scanner input = new Scanner(System.in);
        PetStoreService petStore = new PetStoreServiceImpl();
        Pet pet = null;
        List<Pet> petList = petStore.getPetsInstock(store.getId());
        System.out.println("-------�����ǳ����̵����ڳ��۵ĳ���-------");
        System.out.println("���\t" + "��������\t" + "����\t");
        for (int i = 0; i < petList.size(); i++) {
            pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
        System.out.println("---------��ѡ��Ҫ����ĳ������--------");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            if ((num - 1) < petList.size() && (num - 1) >= 0) {
                pet = petList.get(num - 1);
                System.out.println("------Ҫ�����ĳ�����Ϣ����------");
                System.out.println("�������ֽУ�" + pet.getName() + " ��������ǣ�"
                        + pet.getTypeName());
                System.out.println("��ȷ���Ƿ�������y����������n������");
                String code = input.next();
                if (null != code) {
                    if ("y".equals(code)) {
                        System.out
                                .println("------���������г���������ң���ѡ����Ҫ����������------");
                        List<PetOwner> ownerList = new ArrayList<PetOwner>();
                        PetOwnerDao ownerDao = new PetOwnerDaoImpl();
                        ownerList = ownerDao.getAllOwner();
                        PetOwner petOwner = null;
                        System.out.println("���\t" + "������������\t");
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
                                .println("--------��ѡ��������ν��ף�ϣ�����ٴι��----------");

                    } else {
                        System.out.println("--------������������----------");
                    }
                }
                type = true;
            } else {
                System.out.println("���������밴�������������");
                type = false;
            }
            type = false;// ��ʶ������Ϊfalse���˳�ϵͳ
        }
    }

    /**
     * �����̵���������
     */
    public static void storeBread() {
        PetStoreService petStore = new PetStoreServiceImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("������Ҫ�������������");
        String petType = input.next();
        petStore.bread(petType);
    }

    /**
     * ���������̵�
     */
    public static void createPetStore() {
        PetStoreFactory storeFactory = new PetStoreFactoryImpl();
        storeFactory.createPetStore();
    }


    /**
     * �������˹������
     */
    public static void ownerBuy(PetOwner owner) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------������ѡ��Ҫ����Χ��ֻ����ѡ��������--------");
        System.out.println("1�����������");
        System.out.println("2����������������");
        PetStoreService petStore = new PetStoreServiceImpl();
        PetOwnerService petOwner = new PetOwnerServiceImpl();
        Pet pet = null;
        int num = input.nextInt();
        List<Pet> petList = null;
        // numΪ1ʱ���������
        boolean type = true;
        while (type) {
            if (num == 1) {
                petList = petStore.getPetsInstock(0);
                System.out.println("-------�����ǿ�����-------");
                System.out.println("���\t" + "��������\t" + "����\t" + "\tԪ����\t");
                for (int i = 0; i < petList.size(); i++) {
                    pet = petList.get(i);
                    double price = petStore.charge(pet);// ��õ�����ļ۸�
                    System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
                }
                System.out.println("-------��ѡ��Ҫ�����ĸ�һ�����������ѡ��������-------");
                num = input.nextInt();
                pet = petList.get(num - 1);
                pet.setOwnerId(owner.getId());
                petOwner.buy(pet);
                type = false;
                // numΪ2ʱ��������������
            } else if (num == 2) {
                System.out.println("-------�����ǿ�����-------");
                System.out.println("���\t" + "��������\t" + "����\t" + "\tԪ����\t");
                petList = petStore.getPetsBread();
                for (int i = 0; i < petList.size(); i++) {
                    pet = petList.get(i);
                    double price = petStore.charge(pet);// ��õ�����ļ۸�
                    System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t" + price + "\t");
                }
                System.out.println("-------��ѡ��Ҫ�����ĸ�һ�����������ѡ��������-------");
                String count = input.next();
                if (count.matches("[0-9]*")) {
                    num = Integer.parseInt(count);
                    pet = petList.get(num - 1);
                    pet.setOwnerId(owner.getId());
                    petOwner.buy(pet);
                }
                type = false;
            } else {
                System.out.println("�������������밲��ʾ����");
                type = true;
            }
        }
    }

    /**
     * ��������������̵�����Լ�����
     */
    public static void ownerSell(PetOwner petOwner) {
        Scanner input = new Scanner(System.in);
        PetOwnerService owner = new PetOwnerServiceImpl();
        System.out.println("---------�ҵĳ����б�--------");
        List<Pet> petList = owner.getMyPet(petOwner.getId());
        System.out.println("���\t" + "��������\t" + "����\t");
        for (int i = 0; i < petList.size(); i++) {
            Pet pet = petList.get(i);
            System.out.println((i + 1) + "\t" + pet.getName() + "\t" + pet.getTypeName() + "\t");
        }
        System.out.println("---------��ѡ��Ҫ���۵ĳ������--------");
        boolean type = true;
        while (type) {
            int num = input.nextInt();
            if ((num - 1) < petList.size() && (num - 1) >= 0) {
                Pet pet = petList.get(num - 1);
                System.out.println("------��Ҫ�����ĳ�����Ϣ����------");
                System.out.println("�������ֽУ�" + pet.getName() + " ��������ǣ�"
                        + pet.getTypeName());
                System.out.println("��ȷ���Ƿ�������y����������n������");
                String code = input.next();
                if (null != code) {
                    if ("y".equals(code)) {
                        System.out.println("------���������г����̵꣬��ѡ����Ҫ����������------");
                        List<PetStore> storeList = new ArrayList<PetStore>();
                        PetStoreDao storeDao = new PetStoreDaoImpl();
                        storeList = storeDao.getAllStore();
                        PetStore petStore = null;
                        System.out.println("���\t" + "�����̵�����\t");
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
                                .println("--------��ѡ��������ν��ף�ϣ�����ٴι��----------");

                    } else {
                        System.out.println("--------������������----------");
                    }
                }
                type = true;
            } else {
                System.out.println("���������밴�������������");
                type = false;
            }
            type = false;// ��ʶ������Ϊfalse���˳�ϵͳ
        }
    }

    /**
     * �鿴�̵���Ŀ
     */
    public static void getAccount(long storeId) {
        PetStoreService store = new PetStoreServiceImpl();
        List<Account> list = store.account(storeId);
        for (int i = 0; i < list.size(); i++) {
            Account account = list.get(i);
            String type = null;
            if (1 == account.getDealType()) {
                type = "�̵�������������";
            } else if (2 == account.getDealType()) {
                type = "�������������̵�";
            } else {
                type = "��������֮�佻��";
            }
            System.out.println("��" + (i + 1) + "�ʽ���,��������Ϊ��" + type + "�����׽����:"
                    + account.getPrice() + "��Ԫ��");
        }
    }

}
