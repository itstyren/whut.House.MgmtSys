<template>
  <div class="page">
    <div class="_card fix-detail ">
      <div class="title">
        <span>房屋信息</span>
      </div>
      <div class="content">
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.no)" :disabled="true" v-model.lazy="houseBase.formData.no"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.campusName)" :disabled="true" v-model.lazy="houseBase.formData.campusName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.regionName)" :disabled="true" v-model.lazy="houseBase.formData.regionName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.buildingName)" :disabled="true" v-model.lazy="houseBase.formData.buildingName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.usedArea)" :disabled="true" v-model.lazy="houseBase.formData.usedArea"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.rental)" :disabled="true" v-model.lazy="houseBase.formData.rental"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.address)" :disabled="true" v-model.lazy="houseBase.formData.address"
        />
      </div>
    </div>
    <div class="button-area">
      <button class="right-button" @click="commentSubmit" :class="{'zan-btn--disabled':!canSubmit,'zan-btn':true,'zan-btn--danger':true}">申请住房</button>
    </div>
    <toptips />
  </div>
</template>
<script type="text/ecmascript-6">
import ZanField from "@/components/zan/field";
import ZanTopTips from "@/components/zan/toptips";
import { getComponentByTag } from "@/utils/helper";
import { getSubmitSelectHouseApply } from "@/api";
export default {
  data() {
    return {
      canSubmit: false,
      // 表单控件
      houseBase: {
        address: [],
        selectIndex: 0,
        formData: {},
        no: {
          title: "住房号",
          componentId: "no"
        },
        campusName: {
          title: "所属校区",
          componentId: "campusName"
        },
        regionName: {
          title: "所属区域",
          componentId: "regionName"
        },
        buildingName: {
          title: "所属楼栋",
          buildingName: "buildingName"
        },
        usedArea: {
          title: "住房面积",
          componentId: "usedArea"
        },
        rental: {
          title: "月租金",
          componentId: "rental"
        },
        address: {
          title: "详细住址",
          componentId: "rental",
          type: "textarea"
        }
      }
    };
  },
  // 捕捉页面传递路由
  onLoad(form) {
    console.log(JSON.parse(form.data));
    this.canSubmit = form.data.isOwn;
    this.houseBase.formData = JSON.parse(form.data);
  },
  components: {
    ZanField,
    toptips: ZanTopTips
  },
  methods: {
    // 点击申请
    commentSubmit() {
      if (this.canSubmit) {
        let _this = this;
        wx.showModal({
          title: "提示",
          content: "确认提交(仅可提交一次)",
          success: function(res) {
            if (res.confirm) {
              _this.addSubmit();
            } else if (res.cancel) {
            }
          }
        });
      } else {
        wx.showToast({
          title: "未到选房阶段",
          icon: "none",
          duration: 2500
        });
      }
    },
    //  提交住房申请
    addSubmit() {
      wx.showLoading({
        title: "请稍后"
      });
      let params = {
        staffId: this.$store.state.userinfo.id,
        houseId: this.houseBase.formData.id
      };
      getSubmitSelectHouseApply(params).then(res => {
        wx.hideLoading();
        wx.showToast({
          title: res.message,
          icon: "none",
          duration: 2500
        });
      });
    }
  }
};
</script>
<style scoped lang="scss">
.page {
  padding-top: 20px;
  .fix-detail {
    display: flex;
    flex-direction: column;
    font-size: 16px;
    .title {
      text-align: center;
      color: #6fafea;
    }
    .content {
      margin-top: 15px;
    }
  }

  .weui-rate-wrap {
    margin: 30px 15px;
  }

  .weui-rate {
    display: flex;
  }

  .weui-rate-item {
    position: relative;
    width: 32px;
    height: 32px;
    flex: 0 1 auto;
    margin-right: 6px;
  }

  .weui-rate-item .weui-rate-item-def {
    position: absolute;
    width: 100%;
    height: 100%;
    background-size: 100%;
    background-repeat: no-repeat;
    background-position: 50%;
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAsVBMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADHx8cAAADt7e2ysrJ6enoAAADu7u7MzMzBwcGHh4cAAAAAAADa2trS0tLExMS+vr42NjYAAADv7+/r6+vq6uro6Ojm5ubKysq8vLwAAADr6+vf39/c3NzPz8+1tbWrq6vo6Ojm5ubOzs6vr6+RkZHj4+Pi4uLV1dW4uLienp6ampplZWVWVlbv7+8EiCYnAAAAOnRSTlMAPCsDJgsGOg4hNyMapgj3jGQX/K2eah4Sx7eim0ow/fHv6uGqlzTz0820j4Xo5LGJcNzYvZR7eFpV7G3f4gAAAcpJREFUSMeVVulyskAQdBZwWQ4F5FREjUeiMdd3JvP+DxZCUVskzMrSf+mu3pqZnmGigG1PxoGxcXw7DK1xBsvLKAsLcANjLMwXxNjU589gg7iAmb7BAWv4rr7BAmvMYapr4GODlabF9MugseB6Fu4KW5SZnsEcW2y5oSEQCUocNSwMfo8ST86wRVZiB4/ewPtzj++6gr3j2bSJYUcuc9Zvj3v8hl9BunaYG3VkhhWJmpq+xucdkrg7H16/ZCKyapmA8OoXdziIp8K/hiDqQQjuURPbwGwKHzzr8feBmDTw4EGH/wCyxhEUw/wCoolEDn+G+EvIv60V/nKbH3P7x55wDrf4vmP1cnlK1PzkNCPmqCpV/GNFRs+oLor3MMWQWyEt+FBF2wtowb9ctV6WiicJheC0V8xEpUgzII050IL8DRVQHJeM7px6FbBCOXj0qeDbDmfXzffziVzy753YHx3n2Mn5mmpddJXRLXlmGBkvZdj/U61z47aICRdGU2bBk3l7KajWVb+xxmIFrvSfurBqbsWZUW2rP238li4lJhw2tSsnbn+KGIM569XChJhsnff3AozsqMVgGfRbx1JJ77uztN860775syIFn72pvWujU85XAAAAAElFTkSuQmCC);
  }

  .weui-rate-item-active .weui-rate-item-def {
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAAilBMVEUAAAD/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyr/uyoEd/G7AAAALXRSTlMA+fUzFQ/vioT9vJE9tqNmLRsL2KuYe005JiID6ebhoJtxbF/qzMSxWx9FQgn3q32nAAABYUlEQVRIx5XV2XKDMAwFUJt9h5BAyL5vbe///14zNMShWNg+T8wgwSAZiRGShJmJUrN4G7CNEm7AzCS+ABAuDBJmeMr04xchnvhSO2GHVqUbv+Ro8YlmQoUXXy9+wrsEy9FKiPEW6MQ7lkjwXKbm40Ot9wJh/aNMCNBzVDz+++ihZ5Mn8lK5TR5Ha0htojhvxOeX9slPt1Dapv7JLhnzQxgIfbbaw0C1EnVREp0/QNOBvZw4NPA7e5tbULLmvbnlQcFrWI+9xqhNMfgvR3s3fUh+tClIF0d6nK4gRC41UAkPJpeDMCfnF4EaN+RXX+XxLt3klTThCwRqudQgUKMgBYFaFR5IU+kWwafzGZ9kR+MOwavLsvYUrYtFFQO3LXNgjY7xSxcev9/vxLw7fsP48u8erya9M7/nVOuSdk5ly0EtsnbSFUwQs2ZWSLf8DUAu2eWpzQh2hB37L2vYiGTfXf0Cn7ynb0Flqc0AAAAASUVORK5CYII=);
  }
}
</style>
