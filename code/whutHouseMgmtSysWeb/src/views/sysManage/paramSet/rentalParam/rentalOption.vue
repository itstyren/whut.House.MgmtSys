<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>租赁参数</el-breadcrumb-item>
        <el-breadcrumb-item>租金选项</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-card class="rentalCard">
          <div slot="header">
            <span>当前设置</span>
            <el-button type="text"
                       style="float:right; padding:3px 0"
                       @click="showModifyDialog">点击设置</el-button>
          </div>
          <el-table :data="rentalData"
                    style="width:100%"
                    v-loading="listLoading">
            <el-table-column label="参数名"
                             prop="param"
                             align="center"></el-table-column>
            <el-table-column label="参数值"
                             prop="paramVal"
                             align="center"></el-table-column>
          </el-table>
        </el-card>
      </div>
    </div>
    <!-- 编辑表单 -->
    <el-dialog title="新增选房设置"
               :visible.sync="modifyFormVisible"
               v-loading="submitLoading">
      <el-form :model="modifyFromBody"
               label-width="220px"
               ref="addForm"
               auto>
        <el-row>
          <el-col :span="20">
            <el-form-item label="新老职工分界点："
                          prop="rentalTimeDiv">
              <el-slider v-model="modifyFromBody.rentalTimeDiv"
                         show-input
                         :max="9999"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="老职工优惠比例:"
                          prop="rentalOldDct">
              <el-slider v-model="modifyFromBody.rentalOldDct"
                         show-input
                         :step="0.01"
                         :max="1"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="新职工优惠年限:"
                          prop="rentalNewDctYear">
              <el-slider v-model="modifyFromBody.rentalNewDctYear"
                         show-input
                         :max="9999"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="新职工优惠比例:"
                          prop="rentalNewDct">
              <el-slider v-model="modifyFromBody.rentalNewDct"
                         show-input
                         :step="0.01"
                         :max="1"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="递增开始年限:"
                          prop="limitYear">
              <el-slider v-model="modifyFromBody.limitYear"
                         show-input
                         :max="9999"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="递增比例:"
                          prop="rentUpRate">
              <el-slider v-model="modifyFromBody.rentUpRate"
                         show-input
                         :step="0.01"
                         :max="1"></el-slider>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click.native=" modifyFormVisible = false">取消</el-button>
        <el-button type="primary"
                   @click.native="modifySubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getRentalParam,
  putRentalParam
} from "@/api/sysManage";
import utils from "@/utils/index.js";
export default {
  data () {
    return {
      // 表格数据
      listLoading: "false",
      rentalOption: [],
      rentalData: [],
      // 编辑表单相关数据
      submitLoading: false,
      modifyFormVisible: false,
      modifyFromBody: {
        rentalTimeDiv: "",
        rentalOldDct: "",
        rentTimeBegin: "",
        rentalNewDctYear: "",
        rentalNewDct: "",
        limitYear: '',
        rentUpRate: ''
      }
    };
  },
  // 计算属性
  watch: {
    rentalOption: {
      handler: function (newVal) {
        this.rentalData.push({
          param: "新老职工时间分界点",
          paramVal: newVal.rentalTimeDiv
        });
        this.rentalData.push({
          param: "老职工优惠比例",
          paramVal: newVal.rentalOldDct
        });
        this.rentalData.push({
          param: "新职工优惠年限",
          paramVal: newVal.rentalNewDctYear
        });
        this.rentalData.push({
          param: "新职工优惠比例",
          paramVal: newVal.rentalNewDct
        });
        this.rentalData.push({
          param: "递增开始年限",
          paramVal: newVal.limitYear
        });
        this.rentalData.push({
          param: "递增比例",
          paramVal: newVal.rentUpRate
        });
      },
      deep: true
    }
  },
  // 声明周期调用
  mounted () {
    this.getList();
  },
  methods: {
    // 获取职工职务
    getList () {
      this.listLoading = true;
      let param = {};
      // http请求
      getRentalParam(param)
        .then(res => {
          this.rentalOption = res.data.data.data;
          //console.log(this.rentalOption);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    //显示编辑
    showModifyDialog () {
      this.modifyFormVisible = true;
      this.modifyFromBody = Object.assign({}, this.rentalOption);
      this.modifyFromBody.rentalNewDct = Number(
        this.modifyFromBody.rentalNewDct
      );
      this.modifyFromBody.rentUpRate = Number(
        this.modifyFromBody.rentUpRate
      );
      this.modifyFromBody.rentalOldDct = Number(
        this.modifyFromBody.rentalOldDct
      );
    },
    //编辑提交
    modifySubmit () {
      if (true) {
        this.modifyLoading = true;
        let param = Object.assign({}, this.modifyFromBody);
        putRentalParam(param).then(res => {
          utils.statusinfo(this, res.data);
          this.modifyLoading = false;
          this.modifyFormVisible = false;
          this.rentalData.splice(0, 6);
          this.getList();
        });
      }
    }
  }
};

</script>

<style scoped lang="scss">
.rentalCard {
  width: 60%;
  margin: 100px auto;
  .rentalCard-text {
    margin: 10px 50px;
  }
}
</style>
