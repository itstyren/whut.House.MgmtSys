<template>
  <el-menu class="horizon-menu" default-active="/index" unique-opened mode="horizontal" background-color="#373d41"
    text-color="#fff" router>
    <template v-for="item in permission_routers" v-if="!item.hidden&&item.children">
      <el-menu-item v-if="item.children.length===1 && !item.children[0].children&&!item.alwaysShow" :key="item.children[0].name"
        :index="item.path+'/'+item.children[0].path">
        <span v-if="item.children[0].meta&&item.children[0].meta.title">{{generateTitle(item.children[0].meta.title)}}</span>
      </el-menu-item>

      <el-submenu v-else :index="item.name||item.path" :key="item.name">
        <template slot="title">
          <span v-if="item.meta&&item.meta.title">{{generateTitle(item.meta.title)}}</span>
        </template>

        <template v-for="child in item.children" v-if="!child.hidden">
          <el-menu-item :index="item.path+'/'+child.path" :key="child.name">
            <span v-if="child.meta&&child.meta.title">{{generateTitle(child.meta.title)}}</span>
          </el-menu-item>
        </template>
      </el-submenu>
    </template>
  </el-menu>
</template>

<script type="text/ecmascript-6">
import { generateTitle } from "@/utils/i18n";
import { mapGetters } from "vuex";
export default {
  data() {
    return {};
  },
  computed: {
    ...mapGetters(["permission_routers"])
  },
  methods: {
    generateTitle
  }
};
</script>

<style scoped lang="scss">

</style>
