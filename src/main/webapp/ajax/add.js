var activeInfo={
    activeTheme:this.refs.activeTheme.getValue(),//活动主题            
    startTime:this.refs.startTime.getValue(),//开始时间
    endTime:this.refs.endTime.getValue(),//结束时间
    place:this.refs.place.getValue(),//地点
    activeDetail:this.refs.activeDetail.getValue(),//活动详情
    alarm:this.state.value,//提醒
}
console.log(activeInfo);
let test=function () {
	console.log('aaa');
};
export default activeInfo