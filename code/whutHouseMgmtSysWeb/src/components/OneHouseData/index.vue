<template>
  <!-- 详情表单 -->
  <el-dialog title="房屋详情"
             :visible.sync="visible"
             @close="$emit('update:show', false)"
             :show="show"
             class="detail-modify"
             v-loading="detailLoading">
    <!-- 内层对话框（走马灯） -->
    <el-dialog :title="`房屋编号为${detailData.no}的相关图片`"
               :visible.sync="carouselVisible"
               append-to-body>
      <el-carousel indicator-position="outside"
                   arrow="always"
                   :height="imgHeight">
        <el-carousel-item v-for="(item, index) in pastImageData"
                          :key="index"
                          :index="index">
          <img :src="item"
               class="imgCenter" />
        </el-carousel-item>
      </el-carousel>
    </el-dialog>
    <!-- 住房的表单基础数据 -->
    <el-form :model="detailData"
             label-width="85px"
             status-icon>
      <!-- 上部分 -->
      <div class="top-line">
        <el-row>
          <el-col :span="8">
            <el-form-item label="房屋编号"
                          prop="id">
              <el-input v-model="detailData.id"
                        placeholder="请输入房屋标号"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="校区"
                          prop="name">
              <el-input v-model="detailData.campusName"
                        readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </div>
      <!-- 中间部分 -->
      <el-row>
        <el-col :span="16">
          <el-row>
            <el-col :span="12">
              <el-form-item label="住房类型">
                <el-input v-model="detailData.typeName"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="住房户型">
                <el-input v-model="detailData.layoutName"
                          readonly></el-input>
              </el-form-item>

            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="房屋结构">
                <el-input v-model="detailData.structName"
                          readonly></el-input>
              </el-form-item>

            </el-col>
            <el-col :span="12">
              <el-form-item label="建筑面积">
                <el-input v-model="detailData.buildArea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="使用面积"
                            prop="usedArea">
                <el-input v-model="detailData.usedArea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="占地面积">
                <el-input v-model="detailData.basementArea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="所属区域">
                <el-input v-model="detailData.regionName"
                          readonly></el-input>
              </el-form-item>

            </el-col>
            <el-col :span="12">
              <el-form-item label="所属楼栋">
                <el-input v-model="detailData.buildingName"
                          readonly></el-input>
              </el-form-item>

            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="住房地址">
                <el-input v-model="detailData.address"
                          placeholder="请输入住房地址"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 多行的 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="产权证号">
                <el-input v-model="detailData.proId"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="月租租金">
                <el-input v-model="detailData.rental"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="竣工日期">
                <el-input v-model="detailData.finishTime"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <!-- 中间右边 -->
        <el-col :span="8">
          <!-- 相关图片和上传图片 -->
          <div class="top-line">
            <el-row>
              <el-col :span="24">
                <el-form-item label="相关图片">
                  <span v-if="pastImageData.length===0">暂无图片</span>
                  <template v-else>
                    <el-button type="text"
                               @click="carouselVisible=true">点击查看所有上传的图片</el-button>
                  </template>
                </el-form-item>
              </el-col>
            </el-row>
          </div>
          <!-- 附件上传 -->
          <el-row>
            <el-col :span="24">
              <el-form-item label="相关附件">
                <span v-if="pastFileList.length===0">暂无附件</span>
                <template v-else>
                  <!-- 详情页面显示附件下载链接 -->
                  <el-row>
                    <el-col :span="24"
                            v-for=" (item,index) in pastFileList"
                            :key="index"
                            :index="index">
                      <el-button type="text"
                                 @click="handleDownloadFile(item.name)"> {{item.name}}</el-button>
                    </el-col>
                  </el-row>
                </template>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 备注输入框 -->
          <el-row>
            <el-col :span="24">
              <el-form-item label="备注">
                <el-input v-model="detailData.remark"
                          placeholder="请输入...."
                          type="textarea"
                          :autosize="{ minRows: 2, maxRows: 4}"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 查看历史住房记录 -->

          <el-row style="margin-left:15px;"
                  type="flex"
                  justify="center">
            <el-button @click="getAllResidentDataByHouseId(detailData.id)">历史使用情况</el-button>
          </el-row>
        </el-col>
      </el-row>
    </el-form>
    <!-- 内层对话框（住房历史记录） -->
    <el-dialog :title="`房屋编号为${detailData.id}的历史使用情况`"
               :visible.sync="residentDialogVisiable"
               class="house-Resident-dialog"
               append-to-body>
      <el-table :data="houseResidentData"
                class="table"
                v-loading="houseResidentLoading">
        <el-table-column prop="staffNo"
                         label="职工号"
                         sortable
                         width="90"
                         align="center"></el-table-column>
        <el-table-column prop="staffName"
                         label="姓名"
                         sortable
                         width="140"
                         align="center"></el-table-column>
        <el-table-column prop="deptName"
                         label="工作部门"
                         sortable
                         width="120"
                         align="center"></el-table-column>
        <el-table-column prop="houseRelName"
                         label="入住关系"
                         sortable
                         width="120"
                         align="center"></el-table-column>
        <el-table-column prop="usedArea"
                         label="使用面积"
                         sortable
                         width="120"
                         align="center"></el-table-column>
        <el-table-column prop="bookTime"
                         label="入住时间"
                         align="center"></el-table-column>
        <el-table-column prop="expireTime"
                         label="退出时间"
                         align="center"></el-table-column>
        <el-table-column label="操作"
                         width="180"
                         align="center">
          <template slot-scope="scope">
            <el-button type="danger"
                       size="mini"
                       @click="handleDelRel(scope.$index,scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </el-dialog>
</template>
<script>
import {
  getOneHouseData,
  getAllResidentDataByHouseId,
  deleteResidentLog,
  getStaff
} from "@/api/basiceData";
import utils from "@/utils/index.js";

export default {
  name: 'HouseDetailDialog',
  data () {
    return {
      // 图片上传的域名
      basiceUrl: "http://172.16.65.105:8080/whutHouseMgmtReposity",

      // 是否显示走马灯内层对话框
      carouselVisible: false,
      // 走马灯初始高度
      imgHeight: '500px',
      // 详情表单数据
      detailLoading: false,
      // detailData: {},
      detailFormVisible: false,
      // 是否显示住房详情的对话框      
      visible: this.show,
      detailData: {},
      pastImageData: [],
      // 详情显示的文件列表
      pastFileList: [],
      // 住房历史使用情况的对话框
      residentDialogVisiable: false,
      // 住房历史使用的职工表格数据
      houseResidentData: [],
      // 住房历史使用情况的表格是否加载
      houseResidentLoading: false,
    };
  },
  props: {
    show: {
      type: Boolean,
      default: false
    },
    houseId: [Number, String]
  },
  watch: {
    // 是否显示住房详情的对话框
    show () {
      this.visible = this.show;
      this.getHouseDetailDataByHouseId(this.houseId)
    },
  },
  methods: {
    // 显示住房详情的数据
    getHouseDetailDataByHouseId (houseId) {
      getOneHouseData(this.houseId).then(res => {
        // this.$nextTick(() => {
        this.detailData = Object.assign({}, res.data.data.data);
        // 获取走马灯的图片地址
        this.pastImageData = this.detailData.image ? this.detailData.image.split(',') : []
        if (this.detailData.files) {
          let fileList = this.detailData.files.split(',')
          this.pastFileList = fileList.map((item, index, array) => {
            let name = item.split('\\')
            return {
              name: name[name.length - 1],
              url: item
            }
          })
        } else {
          this.pastFileList = []
        }
      })
      // })

    },
    // 详情页中点击附件直接进行下载
    handleDownloadFile (fileName) {
      let url = `${this.basiceUrl}/fileUpload/fileDownLoad?fileName=${fileName}`
      window.location.href = url
    },
    // 获取住房历史使用情况数据
    getAllResidentDataByHouseId (houseId) {
      this.residentDialogVisiable = true
      this.houseResidentLoading = true
      getAllResidentDataByHouseId(houseId)
        .then(res => {
          return res.data.data.data
        })
        .then(data => {
          let promises = data.map((item, index, array) => {
            return new Promise((resolve, reject) => {
              getStaff({}, item.staffId).then(res => {
                data[index].staffName = res.data.data.data.name
                data[index].deptName = res.data.data.data.deptName
                resolve()
              })
            })
          })
          Promise.all(promises).then(() => {
            this.houseResidentData = data
            this.houseResidentLoading = false
          }).catch(err => {
            this.$message.error("获取住房历史使用情况失败")
          })
        })
    },
    // 删除历史住房纪录
    handleDelRel (index, row) {
      // 删除关系
      this.$confirm("此操作将删除该关系", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.residentId;
          this.houseResidentLoading = true;
          deleteResidentLog(param)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.getAllResidentDataByHouseId(this.houseId)
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },

  }

}
</script>

<style scoped lang="scss">
// @import "../../../styles/variables.scss";

.top-line {
  position: relative;
  margin-bottom: 5px;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: 5px;
    z-index: 1; //left: 5%;
    right: 2%;
  }
}
</style>
