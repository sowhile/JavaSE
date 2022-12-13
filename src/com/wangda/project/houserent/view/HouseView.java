package com.wangda.project.houserent.view;

import com.wangda.project.houserent.domain.House;
import com.wangda.project.houserent.service.HouseService;
import com.wangda.project.houserent.utils.Utility;

/**
 * 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(2);

    /**
     * 显示系统菜单
     */
    public void mainMenu() {
        do {
            System.out.println("==============房屋出租系统菜单==============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出 系 统");
            System.out.println("==========================================");
            System.out.print("\t\t请输入你的选择(1-6): ");
            key = Utility.readMenuSelection();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    search();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    mod();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    System.out.print("确认是否退出？");
                    if (Utility.readConfirmSelection() == 'Y')
                        loop = false;
                    break;
                default:
                    break;
            }
        } while (loop);
    }

    public void listHouses() {
        System.out.println("--------------------------房屋列表----------------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t\t\t地址\t\t\t月租金\t\t状态");
        for (int i = 0; i < houseService.getSize(); i++)
            System.out.println(houseService.getList()[i].toString());
        System.out.println("-------------------------------------------------------------");
        System.out.print("返回上一级菜单请按回车...");
        Utility.back();
    }

    public void addHouse() {
        if (houseService.getSize() >= houseService.getList().length) {
            System.out.println("--------------无法添加,房屋已满，是否扩容？--------------");
            if (Utility.readConfirmSelection() == 'Y')
                houseService.expand();
            else {
                System.out.println("选择不扩容，添加失败！");
                return;
            }
        }
        House house = new House();
        System.out.println("------------------添加房屋-----------------");
        System.out.print("姓名：");
        house.setName(Utility.readString(6, "未命名"));
        System.out.print("电话：");
        house.setPhone(Utility.readString(11, "00000000000"));
        System.out.print("地址：");
        house.setAddress(Utility.readString(11, "00000000000"));
        System.out.print("月租：");
        house.setRent(Utility.readDouble(0.0));
        System.out.print("状态：");
        house.setState(Utility.readString(4, "否"));
        if (houseService.add(house))
            System.out.println("------------------添加成功-----------------");
        else
            System.out.println("------------------添加失败-----------------");
    }

    public void delHouse() {
        System.out.println("------------------删除房屋-----------------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int s = Utility.readInt();
        if (s == -1)
            return;
        System.out.print("确认是否删除,请小心选择,");
        if (Utility.readConfirmSelection() == 'Y')
            if (houseService.delete(s)) {
                System.out.println("------------------删除成功-----------------");
            } else {
                System.out.println("-----------------删除失败！-----------------");
            }
    }

    public void search() {
        System.out.println("------------------查找房屋-------------------");
        System.out.print("请输入ID号(-1退出)：");
        int s = Utility.readInt();
        if (s == -1)
            return;
        if (houseService.search(s) == houseService.getSize())
            System.out.println("未找到。");
    }

    public void mod() {
        System.out.println("-----------------修改房屋信息-----------------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int s = Utility.readInt();
        if (s == -1)
            return;
        int i = houseService.search(s);
        if (i == houseService.getSize()) {
            System.out.println("没有找到该房屋的信息。");
            return;
        }

        System.out.print("姓名" + "(" + houseService.getList()[i].getName() + "):");
        houseService.getList()[i].setName(Utility.readString(6, "未命名"));
        System.out.print("电话" + "(" + houseService.getList()[i].getPhone() + "):");
        houseService.getList()[i].setPhone(Utility.readString(11, "00000000000"));
        System.out.print("地址" + "(" + houseService.getList()[i].getAddress() + "):");
        houseService.getList()[i].setAddress(Utility.readString(11, "00000000000"));
        System.out.print("月租" + "(" + houseService.getList()[i].getRent() + "):");
        houseService.getList()[i].setRent(Utility.readDouble(0.0));
        System.out.print("状态" + "(" + houseService.getList()[i].getState() + "):");
        houseService.getList()[i].setState(Utility.readString(4, "否"));
        System.out.println("-----------------修改成功-----------------");
    }
}
