<template>
  <div class="channel card"
       :style="{height:height,width:width}"
       v-loading="listLoading">
    <div class="title">
      <strong>快速通道</strong>
    </div>
    <div class="content">
      <div class="box"
           v-for="v in channelData"
           :key="v.key">
        <router-link :to="v.path">
          <div class="card-panel-icon-wrapper icon-style">
            <my-icon :icon-class="v.key"
                     class-name="card-panel-icon" />
          </div>
          <div class="script">{{v.label}}</div>
        </router-link>
      </div>
      <div class="box"
           @click="formVisible=true">
        <a>
          <div class="card-panel-icon-wrapper icon-xinzeng">
            <my-icon icon-class="xinzeng"
                     class-name="card-panel-icon" />
          </div>
        </a>
      </div>
    </div>
    <el-dialog title="编辑快速通道"
               class="paramDialog-large"
               :visible.sync="formVisible"
               v-loading="formLoading">
      <el-row type="flex"
              justify="center">
        <el-col :span="22">
          <el-transfer :titles="['未选择', '已选择']"
                       v-model="setData"
                       :data="channelOption"></el-transfer>
        </el-col>
      </el-row>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click.native=" cancel">取消</el-button>
        <el-button type="primary"
                   @click.native="modifySubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import { mapGetters } from "vuex";
import { generateTitleInMethod } from "@/utils/i18n";
import { postQuickPass, getQuickPass } from "@/api/user";

export default {
  data () {
    return {
      listLoading: false,
      formVisible: false,
      formLoading: false,
      channelOption: [],
      channelData: [],
      setData: []
    };
  },
  computed: {
    ...mapGetters(["permission_routers"]),
    staffID () {
      return this.$store.getters.userID;
    }
  },
  created () {
    this.generateArray();
    this.generateChannel();
  },
  props: {
    height: {
      type: String,
      default: "100%"
    },
    width: {
      type: String,
      default: "100%"
    }
  },
  methods: {
    generateTitleInMethod,
    cancel () {
      this.formVisible = false;
    },
    modifySubmit () {
      this.formLoading = true;
      let data = {
        data: this.setData
      };
      postQuickPass(data)
        .then(res => {
          this.formLoading = false;
          this.generateChannel();
        })
        .catch(err => {
          console.log(err);
        });
      this.formVisible = false;
    },
    // 生成目前的用户快速通道
    generateChannel () {
      this.channelData = [];
      this.listLoading = true;
      let params = {
        staffId: this.staffID
      };
      getQuickPass(params).then(res => {
        this.listLoading = false;
        this.setData = res.data.data.data;
        if (this.setData != null) {
          this.setData.forEach(v => {
            this.channelOption.forEach(i => {
              if (v == i.key) this.channelData.push(i);
            });
          });
        } else this.setData = [];
      });
    },
    // 通过路由列表生成穿梭框用的列表
    generateArray () {
      let array = this.permission_routers;
      array.forEach(item => {
        // 过滤隐藏的和没有子元素的
        if (!item.hidden && item.children) {
          if (
            item.children.length === 1 &&
            !item.children[0].children &&
            !item.alwaysShow
          ) {
          } else {
            item.children.forEach(child => {
              this.channelOption.push({
                path: item.path + "/" + child.path,
                key: child.name,
                label: generateTitleInMethod(this, child.meta.title)
              });
            });
          }
        } else {
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
.channel {
  overflow: auto;
}
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
  height: 12%;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: -10px;
    z-index: 1;
    left: 1%;
    right: 1%;
  }
}

.content {
  padding-top: 20px;
  height: 88%;
  display: flex;
  flex-wrap: wrap;
  & > .box {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    justify-content: center;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -ms-flex-direction: column;
    cursor: pointer;
    height: 50%;
    width: 12%;
    &:nth-child(1) {
      .icon-style {
        color: #fff;
        background: #66cccc;
      }
    }
    &:nth-child(2) {
      .icon-style {
        color: #fff;
        background: #ff9999;
      }
    }
    &:nth-child(3) {
      .icon-style {
        color: #fff;
        background: #ffcc00;
      }
    }
    &:nth-child(4) {
      .icon-style {
        color: #fff;
        background: #ff99cc;
      }
    }
    &:nth-child(5) {
      .icon-style {
        color: #fff;
        background: #cc3399;
      }
    }
    &:nth-child(6) {
      .icon-style {
        color: #fff;
        background: #ff6600;
      }
    }
    &:nth-child(7) {
      .icon-style {
        color: #fff;
        background: #25c6fc;
      }
    }
    &:nth-child(8) {
      .icon-style {
        color: #fff;
        background: #ffcc99;
      }
    }
    &:nth-child(9) {
      .icon-style {
        color: #fff;
        background: #82a6f5;
      }
    }
    &:nth-child(10) {
      .icon-style {
        color: #fff;
        background: #35081d;
      }
    }
    &:nth-child(11) {
      .icon-style {
        color: #fff;
        background: #ffb86c;
      }
    }
    &:nth-child(12) {
      .icon-style {
        color: #fff;
        background: #ff5983;
      }
    }
    &:nth-child(13) {
      .icon-style {
        color: #fff;
        background: #77c34f;
      }
    }
    &:nth-child(14) {
      .icon-style {
        color: #fff;
        background: #81c2d6;
      }
    }
    &:nth-child(15) {
      .icon-style {
        color: #fff;
        background: #214579;
      }
    }
    &:nth-child(16) {
      .icon-style {
        color: #fff;
        background: #66cccc;
      }
    }
    &:nth-child(17) {
      .icon-style {
        color: #fff;
        background: #ff9999;
      }
    }
    &:nth-child(18) {
      .icon-style {
        color: #fff;
        background: #ffcc00;
      }
    }
    &:nth-child(19) {
      .icon-style {
        color: #fff;
        background: #ff99cc;
      }
    }
    &:nth-child(20) {
      .icon-style {
        color: #fff;
        background: #cc3399;
      }
    }
    &:nth-child(21) {
      .icon-style {
        color: #fff;
        background: #ff6600;
      }
    }
    &:nth-child(22) {
      .icon-style {
        color: #fff;
        background: #25c6fc;
      }
    }
    &:nth-child(23) {
      .icon-style {
        color: #fff;
        background: #ffcc99;
      }
    }
    &:nth-child(24) {
      .icon-style {
        color: #fff;
        background: #82a6f5;
      }
    }
    &:nth-child(25) {
      .icon-style {
        color: #fff;
        background: #35081d;
      }
    }
    &:nth-child(26) {
      .icon-style {
        color: #fff;
        background: #ffb86c;
      }
    }
    &:nth-child(27) {
      .icon-style {
        color: #fff;
        background: #ff5983;
      }
    }
    &:nth-child(28) {
      .icon-style {
        color: #fff;
        background: #77c34f;
      }
    }
    .icon-xinzeng {
      color: rgba(0, 0, 0, 0.6);
      background: #f5f5f5;
      flex-direction: column;
    }
    .card-panel-icon-wrapper {
      float: left; //margin: 10px 0 0px 10px;
      padding: 2.2vmin;
      -moz-border-radius: 50%;
      -webkit-border-radius: 50%;
      border-radius: 50%;
      transition: all 0.38s ease-out;
      margin-bottom: 10px;
      &:hover {
        box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.4);
      }
    }
    .card-panel-icon {
      float: left;
      font-size: 2vw;
    }
    .script {
      text-align: center;
      font-weight: 600;
      font-size: 0.8em;
      // // 文本强制不换行
      // white-space: nowrap;
      // // 文本溢出显示省略号
      // text-overflow: ellipsis;
      // // 溢出的部分隐藏
      // overflow: hidden;
    }
  }
}
</style>
