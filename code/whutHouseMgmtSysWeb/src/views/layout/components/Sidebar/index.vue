<template>
  <scroll-bar>
    <el-menu mode="vertical" router :default-active="$route.path" :collapse="isCollapse" background-color="#304156" text-color="#bfcbd9" active-text-color="#409EFF">
          <!-- 首页 -->
          <el-menu-item index="/index">
            <template slot="title">
              <span slot="title">首页</span>
            </template>
          </el-menu-item>
          <!-- 系统管理-->
          <el-submenu index="sysManage">
            <template slot="title">
              <span slot="title">系统管理</span>
            </template>
            <el-menu-item index="/sysmanage/paramSet">
              <span>参数设置</span>
            </el-menu-item>
            <el-menu-item index="/paramSet">
              <span>权限控制</span>
            </el-menu-item>
          </el-submenu>
          <!-- 基础资料 -->
          <el-submenu index="basicData">
            <template slot="title">
              <span slot="title">基础资料</span>
            </template>
            <el-menu-item index="/basic/buildingArea">
              <span>楼栋区域</span>
            </el-menu-item>
            <el-menu-item index="/basic/house">
              <span>房屋管理</span>
            </el-menu-item>
            <el-menu-item index="/basic/staff">
              <span>职工管理</span>
            </el-menu-item>
            <el-menu-item index="/basic/houseResident">
              <span>住房登记</span>
            </el-menu-item>
            <el-menu-item index="/basic/importData">
              <span>数据导入</span>
            </el-menu-item>
          </el-submenu>
          <!-- 公房维修 -->
          <el-submenu index="fixManager">
            <template slot="title">
              <span slot="title">公房维修</span>
            </template>
            <el-menu-item index="/fixManage/fixAccept">
              <span>维修受理</span>
            </el-menu-item>
            <el-menu-item index="/fixManage/fixAgree">
              <span>维修审核</span>
            </el-menu-item>
            <el-menu-item index="/fixManage/fixBalance">
              <span>维修结算</span>
            </el-menu-item>
            <el-menu-item index="/fixManage/fixSuper">
              <span>维修直批</span>
            </el-menu-item>
            <el-menu-item index="/fixManage/fixApply">
              <span>维修申请</span>
            </el-menu-item>
            <el-menu-item index="/fixManage/fixApplyManager">
              <span>维修申请管理</span>
            </el-menu-item>
          </el-submenu>
          <!-- 租赁管理 -->
          <el-submenu index="leaseManage">
            <template slot="title">
              <span slot="title">租赁管理</span>
            </template>
            <el-menu-item index="/leaseManage/hireAccept">
              <span>租赁受理</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/hireAgree">
              <span>租赁审核</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/hireApprove">
              <span>租赁审批</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/hireSuper">
              <span>租赁直批</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/hireContract">
              <span>签订合同</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/hireApplyManage">
              <span>申请书管理</span>
            </el-menu-item>
            <el-menu-item index="/leaseManage/rentGenerate">
              <span>租金生成</span>
            </el-menu-item>
          </el-submenu>
          <!-- 网上选房 -->
          <el-submenu index="online">
            <template slot="title">
              <span slot="title">网上选房</span>
            </template>
            <el-menu-item index="/online/hireStafferSet">
              <span>选房资格认定</span>
            </el-menu-item>
            <el-menu-item index="/online/hireHouseSet">
              <span>房源设置</span>
            </el-menu-item>
            <el-menu-item index="/online/selfService">
              <span>自助选房</span>
            </el-menu-item>
            <el-menu-item index="/online/hireApply">
              <span>住房申请</span>
            </el-menu-item>
          </el-submenu>
    </el-menu>
  </scroll-bar>
</template>

<script>
import ScrollBar from '@/components/ScrollBar'
export default {
  components: {  ScrollBar },
  computed: {
    isCollapse() {
      return false
    }
  }
}
</script>
