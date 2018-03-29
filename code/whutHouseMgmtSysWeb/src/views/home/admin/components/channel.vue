<template>
  <div class="channel card" :style="{height:height,width:width}">
    <div class="title">
      <strong>快速通道</strong>
    </div>
    <div class="content">
      <div class="box">
        <router-link to="/basic/houseResident" >
        <div  :class="className">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
        </router-link>
      </div>
      <div class="box">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
      </div>
      <div class="box">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
      </div>
      <div class="box">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
      </div>
      <div class="box">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
      </div>
      <div class="box">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="script">住房登记</div>
      </div>
            <div class="box">
        <div class="card-panel-icon-wrapper icon-xinzeng">
          <my-icon icon-class="xinzeng" class-name="card-panel-icon" />
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      className: " card-panel-icon-wrapper icon-people"
    };
  },
  props: {
    height: {
      type: String,
      default: "350px"
    },
    width: {
      type: String,
      default: "100%"
    }
  },
  components: {},
  methods: {}
};
</script>

<style scoped lang="scss">
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
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
  margin: 15px;
  padding-left: 20px;
  display: flex;
  flex-wrap: wrap;
  & > .box {
    display: flex;
    margin: 10px 50px 0 0;
    flex-direction: column;
    margin-right: 50px;
    cursor: pointer;
    .icon-people {
      color: #fff;
      background: #40c9c6;
    }
    .icon-xinzeng {
      color: rgba(0, 0, 0, 0.6);
      background: #f5f5f5;
    }
    .card-panel-icon-wrapper {
      float: left; //margin: 10px 0 0px 10px;
      padding: 20px;
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
      font-size: 25px;
    }
    .script {
      text-align: center;
      font-weight: 600;
    }
  }
}
</style>
