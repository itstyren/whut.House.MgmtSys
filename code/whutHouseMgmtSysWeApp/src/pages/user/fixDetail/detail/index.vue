<template>
  <div class="page">
    <div class="_card fix-detail ">
      <div class="title">
        <span>维修申请</span>
      </div>
      <div class="content">
        <zan-field v-bind="Object.assign({}, handleFunctions, fixBase.fixType)" :disabled="true" v-model.lazy="fixBase.formData.fixType"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, fixBase.applyTime)" :disabled="true" v-model.lazy="fixBase.formData.applyTime"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, fixBase.fixState)" :disabled="true" v-model.lazy="fixBase.formData.fixState"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, fixBase.processReson)" :disabled="true" v-model.lazy="fixBase.formData.processReason"
        />
        <div class="zan-cell zan-field" v-if="canSubmit||isComment">
          <div class="zan-cell__hd zan-field__title">维修评价</div>
          <div class=" zan-field__input zan-cell__bd">
            <textarea style="height: 3.3em"  class="weui-textarea" 
             v-model.lazy="fixBase.formData.description" :disabled="isComment" placeholder="请输入本次维修评价"></textarea>
            <div class="weui-textarea-counter">限50字</div>

          </div>
        </div>
        <div class="zan-cell zan-field" v-if="canSubmit||isComment">
          <div class="zan-cell__hd zan-field__title">维修评分</div>
          <div class="weui-rate-wrap zan-field__input zan-cell__bd">
            <ul class="weui-rate">
              <li class="weui-rate-item" v-for="n in max" :key="index" :class="{'weui-rate-item-active' : index <= fixBase.formData.ratings}"
                :data-index='index' @click="selectRate">
                <div class="weui-rate-item-def"></div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="button-area">
      <button class="right-button" @click="commentSubmit" :class="{'zan-btn--disabled':!canSubmit,'zan-btn':true,'zan-btn--danger':true}">提交评分</button>
    </div>
    <toptips />
  </div>
</template>
<script type="text/ecmascript-6">
import ZanField from "@/components/zan/field";
import ZanTopTips from "@/components/zan/toptips";
import { getComponentByTag } from "@/utils/helper";
import { putFixComment } from "@/api";
export default {
  data() {
    return {
      canSubmit: false,
      isComment: false,
      // 表单控件
      fixBase: {
        address: [],
        selectIndex: 0,
        formData: {},
        fixType: {
          title: "维修类型",
          componentId: "fixType"
        },
        applyTime: {
          title: "申请时间",
          componentId: "applyTime"
        },
        fixState: {
          title: "处理状态",
          fixState: "fixState"
        },
        processReson: {
          title: "处理说明",
          componentId: "processReson"
        }
      },
      max: 5,
      rateScore: "",
      rateScoreDesc: [
        "非常不满意，各方面都很差",
        "不满意，比较差",
        "一般，还需改善",
        "比较满意，仍可改善",
        "非常满意,无可挑剔"
      ]
    };
  },
   // 捕捉页面传递路由
  onLoad(form) {
    // console.log(JSON.parse(form.data))
    this.fixBase.formData = JSON.parse(form.data);
    if (this.fixBase.formData.ratings == null)
      this.fixBase.formData.ratings = 4;
    if (this.fixBase.formData.fixState == "已审核") {
      this.canSubmit = true;
    } else {
      this.canSubmit = false;
    }
    if (this.fixBase.formData.fixState == "已评价") {
      this.isComment = true;
    }
  },
  components: {
    ZanField,
    toptips: ZanTopTips
  },
  methods: {
    // 提交评分
    commentSubmit() {
      if (this.fixBase.formData.fixState == "已审核") {
        let _this=this
        wx.showModal({
          title: "提示",
          content: "是否确认申请",
          success: function(res) {
            if (res.confirm) {
              wx.showLoading({
                title: "请稍后"
              });
              _this.fixBase.formData.ratings++;
              let data = {
                description: _this.fixBase.formData.description,
                fixId: _this.fixBase.formData.fixId,
                ratings: _this.fixBase.formData.ratings
              };
              putFixComment(data).then(res => {
                wx.hideLoading();
                wx.showToast({
                  title: "提交成功",
                  icon: "success",
                  duration: 2500
                });
                setTimeout(() => {
                  const url = "../main";
                  wx.switchTab({
                    url
                  });
                }, 2500);
              });
            } else if (res.cancel) {
              console.log("用户点击取消");
            }
          }
        });
      } else if (this.fixBase.formData.fixState == "已评价") {
        getComponentByTag(this, "toptips").showZanTopTips("不可重复评价");
      }else{
        getComponentByTag(this, "toptips").showZanTopTips("请等待申请处理");

      }
    },
    selectRate(e) {
      if (this.fixBase.formData.fixState != "已评价") {
        this.fixBase.formData.ratings = e.mp.currentTarget.dataset.index;
        // this.rateScore = this.rateScoreDesc[this.fixBase.formData.ratings];
      } else {
        return;
      }
    }
  }
};
</script>
<style scoped lang="scss">
.page{
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
